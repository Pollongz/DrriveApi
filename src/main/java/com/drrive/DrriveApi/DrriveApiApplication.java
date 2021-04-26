package com.drrive.DrriveApi;

//import com.drrive.DrriveApi.rest.LoginDataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = LoginDataRepository.class)
public class DrriveApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrriveApiApplication.class, args);
	}

}
