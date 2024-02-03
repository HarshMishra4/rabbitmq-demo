package com.harshmishra4.rabbitmqdemo.publisher;

import com.harshmishra4.rabbitmqdemo.config.MessageConfig;
import com.harshmishra4.rabbitmqdemo.entity.MessageDetails;
import com.harshmishra4.rabbitmqdemo.entity.Order;
import com.harshmishra4.rabbitmqdemo.entity.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    private final RabbitTemplate template;

    public OrderPublisher(RabbitTemplate template) {
        this.template = template;
    }


    @PostMapping("/notify")
    public void bookOrder(@RequestBody MessageDetails details) {
//        Adding message to message-queue configured with exchange
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, details);
    }

}
