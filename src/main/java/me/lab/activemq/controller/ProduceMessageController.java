package me.lab.activemq.controller;

import lombok.extern.slf4j.Slf4j;
import me.lab.activemq.model.Student;
import me.lab.activemq.producer.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProduceMessageController {

    @Autowired
    JmsProducer jmsProducer;

    @PostMapping(value = "/api/send/message/queue")
    public Student sendMessageToQueue(@RequestBody Student student) {
        jmsProducer.sendMessageToQueue(student);
        return student;
    }

    @PostMapping(value = "/api/send/message/topic")
    public Student sendMessageToTopic(@RequestBody Student student) {
        jmsProducer.sendMessageToTopic(student);
        return student;
    }
}