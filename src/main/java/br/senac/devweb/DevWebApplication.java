package br.senac.devweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
public class DevWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevWebApplication.class, args);
	}

}
