package com.ms.email.config.consumers;

import com.ms.email.models.dtos.EmailDTO;
import com.ms.email.models.entities.EmailModel;
import com.ms.email.models.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        EmailModel emailModel = emailService.sendEmail(EmailModel.parser(emailDTO));
        System.out.println("E-mail Status: " + emailModel.getStatusEmail().toString());
    }
}
