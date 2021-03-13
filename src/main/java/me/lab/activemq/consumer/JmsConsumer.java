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
public class JmsConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}") //Topic
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Student student = (Student) objectMessage.getObject();
            //do additional processing
            log.info("Thank you so much for this message. Love you!");
            log.info("Received Message: "+ student.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }

    }
}