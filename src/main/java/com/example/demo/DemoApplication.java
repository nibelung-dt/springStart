package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//    @Bean
//    @Profile("!test")
//    public ApplicationRunner run(RestClient.Builder builder) {
//        RestClient restClient = builder.baseUrl("http://localhost:8080").build();
//        return args -> {
//            Quote quote = restClient
//                    .get().uri("/api/random")
//                    .retrieve()
//                    .body(Quote.class);
//            log.info(quote.toString());
//        };
//    }
}