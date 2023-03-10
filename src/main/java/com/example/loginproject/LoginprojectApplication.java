package com.example.loginproject;

import com.example.loginproject.domains.Role;
import com.example.loginproject.repositories.RoleRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginprojectApplication.class, args);
	}

	@Bean
	ApplicationRunner init(RoleRepository roleRepository) {

		return args -> {
			Role adminRole = roleRepository.findByRole("ADMIN");
			if(adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if(userRole == null) {
				Role newUserRole = new Role();
				 newUserRole.setRole("USER");
				 roleRepository.save(newUserRole);
			}
		};
	}

}
