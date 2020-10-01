package br.com.estudos.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.estudos.drogaria.exception.CategoriaException;
import br.com.estudos.drogaria.model.Categoria;
import br.com.estudos.drogaria.repository.CategoriaRepository;
import br.com.estudos.drogaria.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categoria = categoriaRepository.findAll();
		return categoria;
	}
	@GetMapping(value = "/{codigo}")
	public Optional<Categoria> buscar(@PathVariable Short id) {
		try {
		Optional<Categoria> categoriaBuscar = categoriaService.buscarPorCodigo(id);
		return categoriaBuscar;
		} catch(CategoriaException err) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Busca da Categoria não encontrada", err);
		} 
	}
	
	@PostMapping(value = "/adicionar")
	public Categoria inserir(@RequestBody Categoria categoria) {
		Categoria categoriaInserir = categoriaRepository.save(categoria);
		return categoriaInserir;
	}
	@DeleteMapping(value = "/{codigo}")
	public Optional<Categoria> excluir(@PathVariable Short codigo) {
		try {
		Optional<Categoria> categoriaExcluir = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoriaExcluir.get());
		Categoria excluirResultado = categoriaExcluir.get();
		return Optional.ofNullable(excluirResultado);
		} catch(CategoriaException err) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Valor não encontrado", err);
		} 
	}
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditar = categoriaRepository.save(categoria);
		return categoriaEditar;
	}

}
