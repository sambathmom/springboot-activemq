package me.lab.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Configuration
public class ProducerActiveMQConfig {

    @Value("${active-mq.broker-url}")
    private String brokerUrl;

    /**
     * For Producer and Consumer
     *
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);

        //TODO: Check with redelivery time
        /*RedeliveryPolicy policy = new RedeliveryPolicy();
        policy.setMaximumRedeliveries(2);
        activeMQConnectionFactory.setRedeliveryPolicy(policy);*/

        //TODO: Check activemq connection allow only with credential
        /*activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("admin1");*/

        return activeMQConnectionFactory;
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("testqueue");
    }

    /**
     * For Producer
     *
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        return jmsTemplate;
    }

}