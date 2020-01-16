package com.shev.mq.kafka.handler;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public abstract class KafkaTopicConsumeHandler<T>
{
    protected static Map<String, Integer> consumerCache = new ConcurrentHashMap<String, Integer>();

    protected List<String> topics;

    protected String topic;

    protected Class<T> clazz;

    public KafkaTopicConsumeHandler() {}

    public KafkaTopicConsumeHandler(List<String> topics, String topic, Class<T> clazz)
    {
        this.topics = topics;
        this.topic = topic;
        this.clazz = clazz;
    }

    @PostConstruct
    public void initConsumer()
    {
        synchronized (consumerCache)
        {
            if (topics != null)
            {
                for (String curr_topic : topics)
                {
                    if (consumerCache.containsKey(curr_topic))
                    {
                        consumerCache.put(curr_topic, consumerCache.get(curr_topic)+1);
                    } else
                    {
                        consumerCache.put(curr_topic, 1);
                    }
                }
            }
            if (topic != null)
            {
                if (consumerCache.containsKey(topic))
                {
                    consumerCache.put(topic, consumerCache.get(topic)+1);
                } else
                {
                    consumerCache.put(topic, 1);
                }
            }
        }
    }

}
