package me.lab.activemq.producer;

import lombok.extern.slf4j.Slf4j;
import me.lab.activemq.config.ProducerActiveMQConfig;
import me.lab.activemq.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@Slf4j
public class JmsProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;


    public void sendMessageToQueue(Student message) {
        try {
            log.info("Attempting Send message to queue: " + ProducerActiveMQConfig.queueName);
            jmsTemplate.convertAndSend(ProducerActiveMQConfig.queueName, message);
        } catch (Exception e) {
            log.error("Received Exception during send Message Queue: ", e);
        }
    }

    public void sendMessageToTopic(Student message) {
        try {
            log.info("Attempting Send message to topic: " + topic);
            jmsTemplate.convertAndSend(topic, message);
        } catch (Exception e) {
            log.error("Received Exception during send Message Topic: ", e);
        }
    }
}