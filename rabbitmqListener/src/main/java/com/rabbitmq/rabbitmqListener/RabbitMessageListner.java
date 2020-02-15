package com.rabbitmq.rabbitmqListener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMessageListner implements MessageListener{

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Message ["+ new String(message.getBody())+"]");
	}

	

}
