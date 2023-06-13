package com.minsunill.closedvotingsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ClosedVotingSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClosedVotingSiteApplication.class, args);
	}

}
