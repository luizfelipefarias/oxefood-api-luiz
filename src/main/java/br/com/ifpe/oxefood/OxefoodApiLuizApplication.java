package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OxefoodApiLuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiLuizApplication.class, args);
	}

}
