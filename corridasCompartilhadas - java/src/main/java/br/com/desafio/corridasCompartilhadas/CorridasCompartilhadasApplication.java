package br.com.desafio.corridasCompartilhadas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
        "br.com.desafio.testeSimios.model"
        })
@EnableJpaRepositories(basePackages = {
        "br.com.desafio.testeSimios.repository"
        })
@SpringBootApplication
public class CorridasCompartilhadasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorridasCompartilhadasApplication.class, args);
	}

}
