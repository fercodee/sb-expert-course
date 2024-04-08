package github.com.fercodee.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.fercodee.domain.entity.ItemPedido;

public interface ItemsPedidos extends JpaRepository<ItemPedido, Integer>{

}
