package br.com.transparencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.transparencia.model")
@ComponentScan(basePackages = {"br.*"})//MAPEANDO TODOS PACOTES
public class ProjetogdfanailsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetogdfanailsonApplication.class, args);
	}

}
