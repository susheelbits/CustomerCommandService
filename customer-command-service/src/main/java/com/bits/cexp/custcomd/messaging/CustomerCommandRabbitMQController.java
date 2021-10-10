package com.bits.cexp.custcomd.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cexp.custcomd.dto.CustomerDTO;


@RestController
@RequestMapping(value = "/customer-rabbitmq/")
public class CustomerCommandRabbitMQController {

	
	/* @Autowired */
	CustomerCommandRabbitMQSender rabbitMQSender;

    @Autowired
    public CustomerCommandRabbitMQController(CustomerCommandRabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }
    

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("firstName") String firstName,
							@RequestParam("customerId") long customerId) {
		System.out.println("PRODUCER  "+firstName +",   "+customerId);
		CustomerDTO cust=new CustomerDTO();
		cust.setCustomerId(customerId);
		cust.setFirstName(firstName);
		
		rabbitMQSender.send(cust);
		
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}	
}
