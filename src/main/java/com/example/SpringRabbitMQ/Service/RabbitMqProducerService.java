package com.example.SpringRabbitMQ.Service;

import com.example.SpringRabbitMQ.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducerService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routing.key}")
    private String routingKey;

    @Value("${spring.rabbitmq.json.routing.key}")
    private String jsonRoutingKey;

    Logger logger = LoggerFactory.getLogger(RabbitMqProducerService.class);

    public void sendMsg(String msg){
        logger.info("Message sent to rabbit Mq: "+ msg );
        rabbitTemplate.convertAndSend(exchange,routingKey,msg);
    }

    public void sendMsg(User user){
        logger.info("Message sent to rabbit Mq: "+ user.toString() );
        rabbitTemplate.convertAndSend(exchange,jsonRoutingKey,user);
    }
}
