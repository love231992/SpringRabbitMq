package com.example.SpringRabbitMQ.Controller;

import com.example.SpringRabbitMQ.Service.RabbitMqProducerService;
import com.example.SpringRabbitMQ.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqProducerController {
    @Autowired
    RabbitMqProducerService rabbitMqProducerService;

    @GetMapping("/publish/{msg}")
    public ResponseEntity<?> sendMessage(@PathVariable String msg){
        rabbitMqProducerService.sendMsg(msg);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/publish/json")
    public ResponseEntity<?> sendJsonMessage(@RequestBody User user){
        rabbitMqProducerService.sendMsg(user);
        return ResponseEntity.ok("Message sent successfully");
    }
}
