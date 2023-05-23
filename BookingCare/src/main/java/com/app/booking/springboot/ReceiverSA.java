package com.app.booking.springboot;



import java.util.ArrayList;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.app.booking.springboot.entity.Patient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReceiverSA implements MessageListener {
	private QueueConnection qConnect = null;
	private QueueSession qSession = null;
	private Queue queue = null;
	private Gson gson = null;
	ArrayList<Patient> dsbn = new ArrayList<>();
	public ReceiverSA() throws NamingException, JMSException {
		
		Hashtable<String, String> cfi = new Hashtable<String, String>();

        cfi.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        cfi.put(Context.PROVIDER_URL, "tcp://localhost:61616");
        cfi.put("connectionFactoryNames", "cfName");
        cfi.put("queue.SA", "jms.SA");
		
		Context ctx = new InitialContext(cfi);
		QueueConnectionFactory qFactory = (QueueConnectionFactory)ctx.lookup("cfName");
		qConnect = qFactory.createQueueConnection();
		qSession = qConnect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue)ctx.lookup("SA");
		qConnect.start();

		GsonBuilder builder = new GsonBuilder();
		gson = builder.create();
		
		QueueReceiver qReceiver = qSession.createReceiver(queue);
		qReceiver.setMessageListener(this);
		System.out.println("Waiting ...");
		
//		qReceiver.close();
		
	}

	
	public ArrayList<Patient> getAllBN()
	{
		return dsbn;
	}
	@Override
	public void onMessage(Message msg) {
		
		if(msg instanceof TextMessage) {
			try {
				
				String json = ((TextMessage) msg).getText();
				
//				System.out.println(json);
				Patient pt = gson.fromJson(json, Patient.class);
				dsbn.add(pt);
				System.out.println(pt);
				
			} catch (JMSException e) {
				e.printStackTrace();
			}

		}

	}
	public Patient getBN(int index)
	{
		Patient pt = dsbn.get(index);
		dsbn.remove(index);
		return pt;
	}
}
