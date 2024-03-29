package com.crudOperation.PatientRecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PatientRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientRecordApplication.class, args);
	}

}
