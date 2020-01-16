package com.shev.mq.kafka.service;

import com.shev.mq.kafka.handler.KafkaTopicConsumeHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("kafkaProducer")
public class KafkaProducer extends KafkaTopicConsumeHandler
{
    @Resource
    private KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    /*
    public Boolean sendMessage(String topic, Object message)
    {
        try
        {
            kafkaTemplate.send(topic, message);
        } catch (Exception e)
        {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }*/

    public Boolean send(String topic, Object message)
    {
        try
        {
            Integer concurrency = consumerCache.get(topic);
            for (int i=0; i<concurrency; i++)
            {
                kafkaTemplate.send(topic, i, groupId , message);
            }
        } catch (Exception e)
        {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
