package br.com.estudos.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudos.drogaria.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Short>{
	Categoria findByNome(String nome);

}
