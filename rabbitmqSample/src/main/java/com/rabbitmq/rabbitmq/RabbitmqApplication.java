package com.rabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication implements CommandLineRunner{
   @Autowired
	private RabbitTemplate rabbitTemplate;
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleMessage simpleMessage= new SimpleMessage();
		 simpleMessage.setName("First Message");
		 simpleMessage.setDescription("simple description");
		
		rabbitTemplate.convertAndSend("TestExchange","topic",simpleMessage);
	}

}
