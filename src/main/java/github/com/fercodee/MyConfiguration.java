package github.com.fercodee;
// Aqui voc� pode criar configura��es globais para sua aplica��o

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Development // Annotation personalizada
public class MyConfiguration {
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
		};
	}
}
