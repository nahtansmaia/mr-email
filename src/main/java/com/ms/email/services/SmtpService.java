package com.ms.email.services;

import com.ms.email.exception.SmtpNotFoundException;
import com.ms.email.models.SmtpModel;
import com.ms.email.repositories.SmtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class SmtpService {

    @Autowired
    SmtpRepository smtpRepository;

    public SmtpModel saveSMTP(SmtpModel smtpModel) {
        return  smtpRepository.save(smtpModel);
    }

    public List<SmtpModel> listAllSMTP(){
        return smtpRepository.findAll();
    }

    public SmtpModel findById(@PathVariable(value = "id") UUID id) {
        return smtpRepository.findById(id).orElseThrow(() -> new SmtpNotFoundException("SMTP not found"));
    }

}
