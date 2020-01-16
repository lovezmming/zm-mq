package com.shev.mq.kafka.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig
{
    public static final String TOPIC_FACTORY = "kafkaContainerFactory";

    /**
     * 批量消费支持：topic:consumer 为1:n
     * @return
     */
/*    @Bean
    public KafkaListenerContainerFactory kafkaContainerFactory()
    {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConcurrency(5);
        factory.setBatchListener(true);
        return factory;
    }*/

}
