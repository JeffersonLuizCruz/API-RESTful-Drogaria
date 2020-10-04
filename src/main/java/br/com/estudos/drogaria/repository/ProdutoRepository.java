package br.com.estudos.drogaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.drogaria.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Short>{
	public Optional<Produto> findByNome(String nome);

}
