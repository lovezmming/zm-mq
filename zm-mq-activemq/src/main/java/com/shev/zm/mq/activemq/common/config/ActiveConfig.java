package com.shev.zm.mq.activemq.common.config;

import com.shev.zm.mq.common.constant.MqQueue;
import com.shev.zm.mq.common.constant.MqTopic;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class ActiveConfig
{

    @Bean
    public Queue queue()
    {
        return new ActiveMQQueue(MqQueue.ACTIVE_MQ_QUEUE);
    }

    @Bean
    public Topic topic()
    {
        return new ActiveMQTopic(MqTopic.ACTIVE_MQ_TOPIC) ;
    }

    @Bean
    public JmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory)
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //这里必须设置为true，false则表示是queue类型
        factory.setPubSubDomain(true);
        return factory;
    }

}
