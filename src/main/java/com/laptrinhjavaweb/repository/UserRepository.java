package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

//    UserEntity findOneByUserName(String userName);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
