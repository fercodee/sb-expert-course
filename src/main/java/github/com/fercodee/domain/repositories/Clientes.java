package github.com.fercodee.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import github.com.fercodee.domain.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer> {
	
    @Query(" select c from Cliente c where c.nome like ' %:nome%' ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deletarByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}