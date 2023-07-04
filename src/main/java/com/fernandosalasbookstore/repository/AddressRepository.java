package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
