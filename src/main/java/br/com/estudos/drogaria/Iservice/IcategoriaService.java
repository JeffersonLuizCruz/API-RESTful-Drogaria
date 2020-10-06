package br.com.estudos.drogaria.Iservice;

import java.util.Optional;

import br.com.estudos.drogaria.exception.CategoriaException;
import br.com.estudos.drogaria.model.Categoria;

public interface IcategoriaService {
	Optional<Categoria> getCategoriaById(Short id);
	Categoria salvarCategoria(Categoria categoria) throws CategoriaException;

}
