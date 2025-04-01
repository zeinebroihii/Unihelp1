package com.unihelp.user;

import com.unihelp.user.entities.User;
import com.unihelp.user.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserRepository UserRepository) {
		return args -> {

			List<User> userList = List.of(
					User.builder()
							.firstName("Mohammadi")
							.lastName("Imane")
							.email("imane@gmail.com")
							.password("securePassword1")  // Make sure to set a password
							.build(),
					User.builder()
							.firstName("Ismaili")
							.lastName("Aymane")
							.email("aymane@gmail.com")
							.password("securePassword1")  // Make sure to set a password
							.build()
			);
       UserRepository.saveAll(userList);
		};
	}
}
