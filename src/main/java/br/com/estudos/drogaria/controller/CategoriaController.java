package br.com.estudos.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import br.com.estudos.drogaria.serviceImp.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	/**Listar Completa**/
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categoria = categoriaRepository.findAll();
		return categoria;
	}
	
	/**Listar por ID**/
	@GetMapping("/{codigo}")
	public Optional<Categoria> buscar(@PathVariable Short id) {
		try {
		Optional<Categoria> pegarIdCategoria = categoriaService.getCategoriaById(id);
		return pegarIdCategoria;
		} catch(CategoriaException err) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Busca da Categoria não encontrada", err);
		} 
	}
	
	/**Adicionar**/
	@PostMapping("/adicionar")
	public Categoria inserir(@Validated @RequestBody Categoria categoria) throws CategoriaException{
		Categoria categoriaInserir = categoriaService.salvarCategoria(categoria);
		return categoriaInserir;
	}
	
	/**Deletar**/
	@DeleteMapping(value = "/{codigo}")
	public Optional<Categoria> excluir(@PathVariable Short codigo) {
		try {
		Optional<Categoria> excluirCategoriaId = categoriaRepository.findById(codigo);
		categoriaRepository.delete(excluirCategoriaId.get());
		Categoria excluirResultado = excluirCategoriaId.get();
		return Optional.ofNullable(excluirResultado);
		} catch(CategoriaException err) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Valor não encontrado", err);
		} 
	}
	/**Editar**/
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditar = categoriaRepository.save(categoria);
		return categoriaEditar;
	}

}
