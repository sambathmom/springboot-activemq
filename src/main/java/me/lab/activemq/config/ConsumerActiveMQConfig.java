package me.lab.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import java.util.Arrays;

@Configuration
@EnableJms
public class ConsumerActiveMQConfig {

    @Value("${active-mq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);

        //========== Config for consumer message topic
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("me.lab.activemq.model"));
        return activeMQConnectionFactory;
    }


    /**
     * For Consumer
     *
     * @return
     */
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
        // factory.setConcurrency("");
        factory.setPubSubDomain(true);
        return factory;
    }
}