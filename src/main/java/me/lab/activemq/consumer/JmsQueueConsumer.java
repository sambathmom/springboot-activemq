package me.lab.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class JmsQueueConsumer {
    @JmsListener(destination = "testqueue") //Topic
    public void onMessage(Message message) {
        log.info("Queue received message successfully!");
    }
}
