package com.service.support.servicesupport_be_v1.persistance.repository;



import com.service.support.servicesupport_be_v1.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);






}
