package com.harshmishra4.rabbitmqdemo.consumer;

import com.harshmishra4.rabbitmqdemo.config.MessageConfig;
import com.harshmishra4.rabbitmqdemo.entity.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class User {

//    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumerMessageFromQueue(OrderStatus orderStatus) throws InterruptedException {
        System.out.println("Message received from queue : " + orderStatus);
        Thread.sleep(2000);
    }
}
