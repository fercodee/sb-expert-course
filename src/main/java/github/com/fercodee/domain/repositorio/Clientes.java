package github.com.fercodee.domain.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import github.com.fercodee.domain.entity.Cliente;

@Repository
public class Clientes {
	
	private static String INSERT = "inset into clientes (nome) values (?) ";
	
	// JdbcTemplate: database connection, accept script SQL
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Cliente salvar(Cliente cliente) {
		jdbcTemplate.update( INSERT, new Object[]{cliente.getNome()});
		return cliente;
	}
	
	// 06:36
}
