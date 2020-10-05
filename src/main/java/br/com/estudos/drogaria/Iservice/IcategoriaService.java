package br.com.estudos.drogaria.Iservice;

import java.util.Optional;

import br.com.estudos.drogaria.model.Categoria;

public interface IcategoriaService {
	Optional<Categoria> getCategoriaById(Short id);

}
