package me.lab.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import me.lab.activemq.config.ConsumerActiveMQConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class JmsQueueConsumer {
    @JmsListener(destination = "queue1") //queue
    public void onMessage(Message message) {
        log.info("Queue received message successfully!");
    }

    @JmsListener(destination = "queue1") //queue
    public void onMessageQueue(Message message) {
        log.info("Queue2 received message successfully!");
    }
}
