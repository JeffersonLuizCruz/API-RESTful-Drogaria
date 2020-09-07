package br.com.estudos.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.drogaria.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Short>{

}
