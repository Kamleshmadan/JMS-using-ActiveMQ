package com.JMS.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
	private static String queueName = "MESSAGE_QUEUE";

	public static void main(String[] args) throws JMSException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queueName);

		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage("Hello Sushil");

		producer.send(message);

		System.out.println("Message '" + message.getText() + ", Sent Successfully to the Queue");
		connection.close();
	}
}