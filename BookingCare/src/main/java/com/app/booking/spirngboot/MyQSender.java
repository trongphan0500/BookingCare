//package com.app.booking.spirngboot;
//
//import java.util.Hashtable;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Queue;
//import javax.jms.QueueConnection;
//import javax.jms.QueueConnectionFactory;
//import javax.jms.QueueSender;
//import javax.jms.QueueSession;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
//
////import com.example.entity.Benhnhan;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//
//public class MyQSender {
//
//	public QueueConnection qConnect = null;
//    public QueueSession qSession = null;
//    public Queue queue = null;
//    private String queueName = null;
//    private Gson gson = null;
//
//    public MyQSender() throws NamingException, JMSException {
//		Hashtable<String, String> cfi = new Hashtable<String, String>();
//
//        cfi.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
//        cfi.put(Context.PROVIDER_URL, "tcp://localhost:61616");
//        cfi.put("connectionFactoryNames", "cfName");
//        cfi.put("queue.DSBN", "jms.DSBN");
//
//		Context ctx = new InitialContext(cfi);
//		QueueConnectionFactory qFactory = (QueueConnectionFactory) ctx.lookup("cfName");
//		qConnect = qFactory.createQueueConnection();
//		qSession = qConnect.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//		queue = (Queue) ctx.lookup("DSBN");
//		qConnect.start();
//
//		GsonBuilder builder = new GsonBuilder();
//		builder.setPrettyPrinting();
//		gson = builder.create();
//
//	}
//
//    public void sendMessage(String message) throws JMSException {
//        // Set message group ID to "Group1"
//        TextMessage textMessage = qSession.createTextMessage(message);
//        textMessage.setStringProperty("JMSXGroupID", "Group1");
//        
//        QueueSender queueSender = qSession.createSender(queue);
//        queueSender.send(textMessage);
//        System.out.println("Message sent to " + queueName + ": " + message);
//    }
//
//    public void close() throws JMSException {
//        if (qConnect != null) {
//            qConnect.close();
//        }
//    }
//
////    public static void main(String[] args) throws NamingException, JMSException {
////    	MyQSender queueSender1 = new MyQSender();
////        queueSender1.sendMessage("Hello from Queue1");
////
////        queueSender1.close();
////        
////    }
	
	
//}

