package ru.geekbrains.mai.market.maimarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MaiMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaiMarketApplication.class, args);
	}

}
