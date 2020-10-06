package br.com.estudos.drogaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudos.drogaria.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Short>{
	public Produto findByNome(Produto nome);

}
