package me.lab.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import me.lab.activemq.model.Student;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsTopicFirstConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}") //Topic
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Student student = (Student) objectMessage.getObject();
            Thread.sleep(10 * 1000);
            log.info("First Message Topic receiver: " + student.toString());
        } catch (Exception e) {
            log.error("First Message Topic receiver exception : " + e);
        }

    }
}