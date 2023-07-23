package com.example.springboot_dev.User.Repository;

import com.example.springboot_dev.User.Data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUname(String name);

}
