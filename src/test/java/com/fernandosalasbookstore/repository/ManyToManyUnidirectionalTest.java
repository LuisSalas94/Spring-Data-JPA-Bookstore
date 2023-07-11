package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Role;
import com.fernandosalasbookstore.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        User user = new User();
        user.setFirstName("Fernando");
        user.setLastName("Salas");
        user.setEmail("luisfernando@gmail.com");
        user.setPassword("password");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);
    }

    @Test
    void updateUser() {
        User user = userRepository.findById(1L).get();
        user.setFirstName("Luis");
        user.setEmail("luis@gmail.com");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRoles().add(roleUser);
        userRepository.save(user);
    }

    @Test
    void fetchUser() {
        User user = userRepository.findById(1L).get();
        System.out.println("Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        user.getRoles().forEach(role -> {
            System.out.println("Role Name: " + role.getName());
        });
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(1L);
    }

}
