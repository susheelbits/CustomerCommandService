package com.bits.cexp.custcomd.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bits.cexp.custcomd.dto.CustomerDTO;

/**
 * Sending message to Query DB for adding, updating, deletig the Customer 
 * 
 *
 */
@Service
public class CustomerCommandRabbitMQSender {
	private RabbitTemplate rabbitTemplate;

    @Autowired
    public CustomerCommandRabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
	@Value("${spring.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(CustomerDTO custDTO) {
		System.out.println("CustomerCommandRabbitMQSender Send msg = " + custDTO);
		rabbitTemplate.convertAndSend(exchange, routingkey, custDTO);
	}	
}
