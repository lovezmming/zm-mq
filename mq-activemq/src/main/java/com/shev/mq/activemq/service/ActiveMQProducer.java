package com.shev.mq.activemq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

@Service("activeMQProducer")
@Slf4j
public class ActiveMQProducer
{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public Boolean sendMessage(String destination, String message)
    {
        try
        {
            jmsMessagingTemplate.convertAndSend(destination, message);
        } catch (Exception e)
        {
            log.error("message send error ! " + e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean sendQueueMessage(Queue queue, String message)
    {
        try
        {
            jmsMessagingTemplate.convertAndSend(queue, message);
        } catch (Exception e)
        {
            log.error("message send error ! " + e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean sendTopicMessage(Topic topic, String message)
    {
        try
        {
            jmsMessagingTemplate.convertAndSend(topic, message);
        } catch (Exception e)
        {
            log.error("message send error ! " + e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
