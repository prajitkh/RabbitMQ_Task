package com.RabbitMq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RabbitMq.RabbitMQConfig;
import com.RabbitMq.entity.Order;
import com.RabbitMq.entity.OrderDto;

@RestController
@RequestMapping("/api")
public class RMQProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping()
	public OrderDto placeOrder(@RequestBody Order order) {

		OrderDto dto = new OrderDto();
		dto.setMessage("Hi ,producer your order placed ");
		dto.setOrder(order);
		dto.setOrderStatus("order placed");

		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, dto);
		return dto;
	}

}
