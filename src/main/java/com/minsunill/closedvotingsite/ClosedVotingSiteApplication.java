package com.minsunill.closedvotingsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class ClosedVotingSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClosedVotingSiteApplication.class, args);
	}

}
