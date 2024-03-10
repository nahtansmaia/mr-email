package com.ms.email.models.repositories;

import com.ms.email.models.entities.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

    List<EmailModel> findByEmailFrom(String emailFrom);

    List<EmailModel> findByEmailTo(String emailTo);

}
