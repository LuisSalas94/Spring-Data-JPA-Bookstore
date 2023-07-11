package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
