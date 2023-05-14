package com.app.booking.spirngboot;

//import javax.jms.JMSException;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpirngbootApplication {
	

	public static void main(String[] args)  {
		
		SpringApplication.run(SpirngbootApplication.class, args);
//		MyQSender sender = new MyQSender();
//		sender.sendMessage("Hello from Queue1");
//		sender.close();
	}

}
