package br.com.estudos.drogaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.drogaria.Iservice.IprodutoService;
import br.com.estudos.drogaria.exception.ProdutoException;
import br.com.estudos.drogaria.model.Produto;
import br.com.estudos.drogaria.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private IprodutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/{nome}")
	public Optional<Produto> listarPorNome(@PathVariable String nome) throws ProdutoException{
		Optional<Produto> listar = produtoService.getProdutoByNome(nome);
		return listar;
	}
	
	@GetMapping
	public List<Produto>ListarTudo(){
		List<Produto> listaTudo = produtoRepository.findAll();
		return listaTudo;
	}
	
	//
	@PostMapping("/adicionar")
	public Optional<Produto> inserir(@Validated @RequestBody Produto produto) throws ProdutoException {
		Optional<Produto> salvaProduto = produtoService.salvarProduto(produto);
		return salvaProduto;
	}
	
	public Produto delete() {
		return null;
	}

}
