package github.com.fercodee;

import github.com.fercodee.domain.entity.Cliente;
import github.com.fercodee.domain.entity.Pedido;
import github.com.fercodee.domain.repositories.Clientes;
import github.com.fercodee.domain.repositories.Pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos) {
		return args -> {
			System.out.println("Salvando clientes");
			Cliente fulano = new Cliente("Fulano");
			clientes.save(fulano);

			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

			// Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
			// System.out.println(cliente);
			// System.out.println(cliente.getPedidos());

			pedidos.findByCliente(fulano).forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

/*
 * Anotações 1. Bean -> Configurações que podem ser aplicadas em todo o contexto
 * da sua aplicação. 2. @Value -> Posso acessar key do "application.properties".
 * 3. @Autowired -> Só funciona em classes que estiverem marcada com annotations
 * do spring. 4. Você pode definir diversas configurações no
 * application.properties, como contexto, porta aonde a aplicação irá rodar. 5.
 * Com os Profiles, você pode criar vários arquivos properties com configurações
 * diferentes para antender deviersos ambientes (teste, produção e etc...). 6.
 * Você também pode definir em que perfil determinados beans poderão ser usados,
 * basta usar a notation @Profile.
 * 
 * 7. Quando você possuir uma classe de configuração que possua mais um bean
 * declarada nela, você deverá usar além do @Autowired
 * o @Qualifier("NomeDoSeuBean"), especificando qual bean será usado.
 */