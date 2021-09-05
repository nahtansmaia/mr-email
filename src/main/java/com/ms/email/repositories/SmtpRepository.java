package com.ms.email.repositories;

import com.ms.email.models.SmtpModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SmtpRepository extends JpaRepository<SmtpModel, UUID> {
}
