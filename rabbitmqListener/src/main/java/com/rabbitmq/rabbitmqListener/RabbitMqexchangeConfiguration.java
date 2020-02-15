package com.rabbitmq.rabbitmqListener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqexchangeConfiguration {
	@Bean
	Exchange myExchange() {
		return new TopicExchange("MyExchange");
	}
	@Bean
	Exchange my2Exchange() {
		return ExchangeBuilder.directExchange("My2Exchange")
				.autoDelete()
				.internal()
				.build();
	}
@Bean
Exchange newExchange() {
	return ExchangeBuilder.directExchange("TopictesTestExchange")
			.autoDelete()
			.durable(true)
			.internal()
			.build();
}

@Bean
Exchange topicExchange() {
	return ExchangeBuilder.topicExchange("Topictes1TestExchange")
			.autoDelete()
			.durable(true)
			.internal()
			.build();
}

@Bean
Exchange fanoutExchange() {
	return ExchangeBuilder.fanoutExchange("FanoutTestExchange")
			.autoDelete()
			.durable(true)
			.internal()
			.build();
}
@Bean
Exchange headersExchange() {
	return ExchangeBuilder.headersExchange("HeadersTestExchange")
			.autoDelete()
			.durable(true)
			.internal()
			.ignoreDeclarationExceptions()
			.build();
}
}
