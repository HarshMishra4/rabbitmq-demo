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

//    @PostMapping("/{restaurantName}")
//    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
//        order.setOrderId(UUID.randomUUID().toString());
////        restaurant service
////        payment service
//        OrderStatus status = new OrderStatus(order, "PROCESS", "Order placed in : " + restaurantName);
////        Adding message to message-queue configured with exchange
//        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, status);
//        return "Success";
//    }

    @PostMapping("/notify")
    public void bookOrder(@RequestBody MessageDetails details) {
//        Adding message to message-queue configured with exchange
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, details);
    }

}

// Comparison B/W Kafka & RabbitMQ -> https://www.youtube.com/watch?v=_5mu7lZz5X4

//C:\Program Files\RabbitMQ Server\rabbitmq_server-3.12.10\sbin
//rabbitmq-plugins enable rabbitmq_management
//rabbitmq-server.bat start
// If one is running RabbitMQ via rabbitmq-server.bat -detached,
// the command for shutting it down is rabbitmqctl.bat shutdown

