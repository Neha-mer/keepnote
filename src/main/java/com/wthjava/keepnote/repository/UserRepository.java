package com.wthjava.keepnote.repository;

import com.wthjava.keepnote.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>
{
    Optional<User> findByUsername(String username);
}
