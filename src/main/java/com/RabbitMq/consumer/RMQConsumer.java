package com.RabbitMq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.RabbitMq.RabbitMQConfig;
import com.RabbitMq.entity.OrderDto;

@Component
public class RMQConsumer {

	@RabbitListener(queues = RabbitMQConfig.QUEUE)
	public void consume(OrderDto dto) {
		System.out.println("Consumer consume messages from queue" + dto);
	}
}
