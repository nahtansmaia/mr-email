package com.ms.email.consumers;

import com.ms.email.dtos.SmtpDTO;
import com.ms.email.models.SmtpModel;
import com.ms.email.services.SmtpService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SmtpConsumer {

    @Autowired
    SmtpService smtpService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload SmtpDTO smtpDTO) {
        SmtpModel smtpModel = smtpService.saveSmtp(SmtpModel.parser(smtpDTO));
        System.out.println("SMTP host: " + smtpModel.getHost());
    }
}
