package br.com.estudos.drogaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudos.drogaria.exception.CategoriaException;
import br.com.estudos.drogaria.model.Categoria;
import br.com.estudos.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {//Esse tratamento de erro não está funcionando. 
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> buscarPorCodigo(Short id) {
		Optional<Categoria> buscaException = categoriaRepository.findById(id);
		if(buscaException.isEmpty()) {
			throw new CategoriaException();
		}
		return buscaException;
	}

}
