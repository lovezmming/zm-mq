package com.shev.zm.mq.mq.activemq;

import com.shev.mq.activemq.config.ActiveMQConfig;
import com.shev.zm.mq.common.MqQueue;
import com.shev.zm.mq.common.MqTopic;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQTopicConsumer
{
    @JmsListener(destination= MqQueue.ACTIVE_MQ_MY_QUEUE)
    public void ListenMyQueue(String msg)
    {
        System.out.println("ActiveMQTopicConsumer接收到queue消息：" + msg);
    }

    @JmsListener(destination= MqTopic.ACTIVE_MQ_MY_TOPIC, containerFactory = ActiveMQConfig.TOPIC_FACTORY)
    public void ListenMyTopic(String msg)
    {
        System.out.println("ActiveMQTopicConsumer接收到topic消息：" + msg);
    }
}