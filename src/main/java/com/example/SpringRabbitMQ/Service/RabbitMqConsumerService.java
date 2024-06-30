package com.example.SpringRabbitMQ.Service;

import com.example.SpringRabbitMQ.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumerService {

    Logger logger = LoggerFactory.getLogger(RabbitMqConsumerService.class);

    @RabbitListener(queues = "spring-queue")
    public void consumeMsg(String msg){
        logger.info("Consumer received the msg :"+ msg);
    }

    @RabbitListener(queues = "spring-jsonQueue")
    public void consumeJsonMsg(User user){
        logger.info("Consumer received the msg :"+ user.toString());
    }
}
