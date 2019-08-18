package com.shopingCart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
public class MessageSaveApplication {
  private Logger log = LoggerFactory.getLogger(MessageSaveApplication.class);

  @Bean
  public MessageConverter messageConverter() {
    log.debug("Start");
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

  @Bean
  public JmsListenerContainerFactory<?> queueListenerFactory() {
    log.debug("start");
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setMessageConverter(messageConverter());
    return factory;
  }

  public static void main(String[] args) {
    SpringApplication.run(MessageSaveApplication.class, args);
  }
}
