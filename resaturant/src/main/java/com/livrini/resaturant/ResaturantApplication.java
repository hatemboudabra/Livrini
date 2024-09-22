package com.livrini.resaturant;

import com.livrini.resaturant.role.Role;
import com.livrini.resaturant.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableJpaRepositories
@EnableAsync
public class ResaturantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResaturantApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository){
		return 	args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}
}
