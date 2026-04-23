package com.goggles.payment_service;

import com.goggles.config.event.EventConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import(EventConfig.class)
@SpringBootApplication(scanBasePackages = {"com.goggles"})
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.goggles"})
@EntityScan(basePackages = {"com.goggles"})
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
