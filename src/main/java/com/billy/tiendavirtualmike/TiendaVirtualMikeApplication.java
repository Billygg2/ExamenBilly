package com.billy.tiendavirtualmike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan
public class TiendaVirtualMikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualMikeApplication.class, args);
	}

}
