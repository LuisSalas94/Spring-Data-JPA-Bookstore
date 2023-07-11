package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
