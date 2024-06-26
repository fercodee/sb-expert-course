package github.com.fercodee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendasApplication {	

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}

/*
 * Anotações
 * 1. Bean -> Configurações que podem ser aplicadas em todo o contexto
 * da sua aplicação.
 * 2. @Value -> Posso acessar key do "application.properties".
 * 3. @Autowired -> Só funciona em classes que estiverem marcada com annotations
 * do spring.
 * 4. Você pode definir diversas configurações no
 * application.properties, como contexto, porta aonde a aplicação irá rodar.
 * 5. Com os Profiles, você pode criar vários arquivos properties com
 * configurações
 * diferentes para antender deviersos ambientes (teste, produção e etc...).
 * 6. Você também pode definir em que perfil determinados beans poderão ser
 * usados,
 * basta usar a notation @Profile.
 * 7. Quando você possuir uma classe de configuração que possua mais um bean
 * declarada nela, você deverá usar além do @Autowired
 * o @Qualifier("NomeDoSeuBean"), especificando qual bean será usado.
 */