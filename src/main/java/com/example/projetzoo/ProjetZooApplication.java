package com.example.projetzoo;

import com.example.projetzoo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties
public class ProjetZooApplication implements CommandLineRunner {


        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public ProjetZooApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args) throws Exception {
//        SecurityUser user = new SecurityUser();
//        user.setUsername("flavian");
//        user.setPassword(passwordEncoder.encode("Test1234="));
//        user.setEmail("flavian.ovyn@bstorm.be");
//        user.setCreatedAt(LocalDate.now());
//        user.setUpdatedAt(LocalDate.now());
//
//        this.userRepository.save(user);
        }

    public static void main(String[] args) {
        SpringApplication.run(ProjetZooApplication.class, args);
    }

}
