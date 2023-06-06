package com.fetchrepostask.fetchrepos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class FetchReposApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchReposApplication.class, args);
	}

	public void fetchRepositories() {
		RestTemplate restTemplate = new RestTemplateBuilder().build();
		
	}
}
