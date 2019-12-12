package com.shev.zm.mq.activemq.mq;

import com.shev.zm.mq.common.constant.MqQueue;
import com.shev.zm.mq.common.constant.MqTopic;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer
{

    @JmsListener(destination= MqQueue.ACTIVE_MQ_QUEUE)
    public void ListenQueue(String msg)
    {
        System.out.println("接收到queue消息：" + msg);
    }

    @JmsListener(destination= MqTopic.ACTIVE_MQ_TOPIC, containerFactory = "jmsTopicListenerContainerFactory")
    public void ListenTopic(String msg)
    {
        System.out.println("接收到topic-1消息：" + msg);
    }
}
