//package queueTemplateAPI.Controller.JMS.Config;
//
//import lombok.Data;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
//import org.springframework.jms.support.converter.MessageConverter;
//import queueTemplateAPI.Integration.Model.CEP;
//
//import javax.jms.ConnectionFactory;
//import javax.jms.Queue;
//
//@Configuration
//@EnableJms
//@Data
//public class JmsConfig {
//
//
////    @Value("${spring.activemq.user}")
////    private String user;
//
////    @Value("${spring.activemq.password}")
////    private String password;
//
//    @Value("${spring.activemq.broker-url}")
//    private String urlMessageBroker;
//
////    @Bean
////    public Queue queue() {
////        return new ActiveMQQueue("cep.queue");
////    }
//
//    @Bean (name = "activeConnect")
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//        factory.setBrokerURL(urlMessageBroker);
////        factory.setUserName(user);
////        factory.setPassword(password);
//        return factory;
//    }
//
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(activeMQConnectionFactory());
//    }

//    @Bean(name = "jmsConnection")
//    public JmsTemplate jmsTemplate(@Qualifier("activeConnect") ActiveMQConnectionFactory factory,
//                                   @Qualifier("jacksonConverter") MessageConverter converter) {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setMessageConverter(converter);
//        jmsTemplate.setConnectionFactory((ConnectionFactory) factory);
//        return jmsTemplate;
//    }

//    @Bean(name = "jacksonConverter")
//    public MappingJackson2MessageConverter converter() {
//        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
//        cep = new CEP();
//        cep.setCep("09090");
//        cep.setRua("bla");
//        messageConverter.toMessage(cep, );
//    }
//}
