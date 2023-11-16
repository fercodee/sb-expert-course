package github.com.fercodee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import github.com.fercodee.domain.entity.Cliente;
import github.com.fercodee.domain.repositorio.Clientes;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			System.out.println("Salvando clientes...");
			clientes.salvar(new Cliente("Jesus"));
			clientes.salvar(new Cliente("Zé Cliente"));

			System.out.println("Listando clientes...");
			List<Cliente> todosClientes = clientes.obterTodos();
			// System.out::println -> reference method
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes...");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado");
				clientes.atualizar(c);
			});

			System.out.println("Listando clientes...");
			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes...");
			clientes.buscarPorNome("Cli").forEach(System.out::println);

			// System.out.println("Deletando clientes...");
			// clientes.obterTodos().forEach(c -> {
			//	clientes.deletar(c);
			// });

			todosClientes = clientes.obterTodos();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum cliente encontrado.");
			} else {
				todosClientes.forEach(System.out::println);
			}

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
