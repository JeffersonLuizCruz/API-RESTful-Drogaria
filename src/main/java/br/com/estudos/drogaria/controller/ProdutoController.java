package br.com.estudos.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	/**Lista Completa**/
	@GetMapping
	public List<Produto>ListarTudo(){
		List<Produto> listaTudo = produtoRepository.findAll();
		return listaTudo;
	}
	
	/**Adicionar**/
	@PostMapping("/adicionar")
	public Produto inserir(@Validated @RequestBody Produto produto) throws ProdutoException {
		Produto salvaProduto = produtoService.salvarProduto(produto);
		return salvaProduto;
	}
	/**Deletar**/
	public Produto editar() {
		return null;
	}

}
