package com.ms.email.models.repositories;

import com.ms.email.models.entities.SmtpModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SmtpRepository extends JpaRepository<SmtpModel, UUID> {
}
