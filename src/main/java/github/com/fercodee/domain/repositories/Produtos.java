package github.com.fercodee.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.fercodee.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{
    
}
