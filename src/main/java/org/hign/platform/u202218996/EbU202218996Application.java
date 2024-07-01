package org.hign.platform.u202218996;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EbU202218996Application {

	public static void main(String[] args) {
		SpringApplication.run(EbU202218996Application.class, args);
	}

}
