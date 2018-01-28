package com.alltej.oauthservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class OauthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServiceApplication.class, args);
	}

	@Bean CommandLineRunner demo(AccountRepository accountRepository) {
		return args -> Stream.of("john,welcome", "pete,welcome", "rafa,welcome")
                .map( tpl -> tpl.split( "," ) )
                .forEach( tpl -> accountRepository.save( new Account( tpl[0], tpl[1], true ) ) );
	}
}
