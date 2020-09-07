package br.com.estudos.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.drogaria.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

}
