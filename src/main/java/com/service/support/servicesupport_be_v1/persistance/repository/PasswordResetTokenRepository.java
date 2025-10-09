package com.service.support.servicesupport_be_v1.persistance.repository;

import com.service.support.servicesupport_be_v1.persistance.entity.PasswordResetTokenEntity;
import com.service.support.servicesupport_be_v1.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetTokenEntity, Long> {
    Optional<PasswordResetTokenEntity> findByUser(UserEntity user);

    Optional<PasswordResetTokenEntity> findByToken(String token);
}

