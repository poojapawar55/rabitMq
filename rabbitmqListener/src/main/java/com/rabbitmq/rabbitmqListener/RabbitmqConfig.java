package com.rabbitmq.rabbitmqListener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

	private static final String MY_QUEUE = "MyQueue";
	
	@Bean
	Queue myQueue() {
		return new Queue( MY_QUEUE,true);
		
	}
	@Bean
	Exchange topic1Exchange() {
		return ExchangeBuilder.topicExchange("Topictest2TestExchange")
				.autoDelete()
				.durable(true)
				.internal()
				.build();
	}
//	@Bean
//	Exchange myExchange() {
//		return ExchangeBuilder.topicExchange("MYexchange")
//				.durable(true)
//				.build();
//	}
	@Bean
	Exchange testExchange() {
		return ExchangeBuilder.topicExchange("TestExchange")
				.durable(true)
				.build();
	}
	
	@Bean 
	Exchange YourExchange() {
		return ExchangeBuilder.topicExchange("YourExchange")
				.durable(true)
				.build();
	}
	@Bean
	Binding binding() {
		return BindingBuilder
				.bind(myQueue())
				.to(testExchange())
				.with("topic")
				.noargs();
				
				
	}
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingconectionfactory =new CachingConnectionFactory("localhost");
		cachingconectionfactory.setUsername("root");
		cachingconectionfactory.setPassword("example");
		return cachingconectionfactory;
	}
	@Bean
	MessageListenerContainer messageListnerContainer() {
		SimpleMessageListenerContainer simpleMessageListner = new SimpleMessageListenerContainer();
		simpleMessageListner.setConnectionFactory(connectionFactory());
		simpleMessageListner.setQueues(myQueue());
		simpleMessageListner.setMessageListener(new RabbitMessageListner());
		return simpleMessageListner;
	}
	
}
