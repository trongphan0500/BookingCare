package com.app.booking.springboot;



import java.util.Hashtable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.app.booking.springboot.entity.Patient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SenderSA {

	public QueueConnection qConnect = null;
	public QueueSession qSession = null;
	public Queue queue = null;
	private String queueName = null;
	private Gson gson = null;

	public SenderSA() throws NamingException, JMSException {
		Hashtable<String, String> cfi = new Hashtable<String, String>();

		cfi.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		cfi.put(Context.PROVIDER_URL, "tcp://localhost:61616");
		cfi.put("connectionFactoryNames", "cfName");
		cfi.put("queue.SA", "jms.SA");

		Context ctx = new InitialContext(cfi);
		QueueConnectionFactory qFactory = (QueueConnectionFactory) ctx.lookup("cfName");
		qConnect = qFactory.createQueueConnection();
		qSession = qConnect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup("SA");
		qConnect.start();

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		gson = builder.create();

	}

	public void sendMessage(Patient pt) throws JMSException {
		// Set message group ID to "Group1"
		String json = gson.toJson(pt);
		Message msg = qSession.createTextMessage(json);
		QueueSender qSender = qSession.createSender(queue);
		qSender.send(msg);
	}

	public void close() throws JMSException {
		if (qConnect != null) {
			qConnect.close();
		}
	}
	
}


