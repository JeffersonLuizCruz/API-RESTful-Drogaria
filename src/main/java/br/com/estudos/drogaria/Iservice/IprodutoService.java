package br.com.estudos.drogaria.Iservice;

import java.util.Optional;

import br.com.estudos.drogaria.exception.ProdutoException;
import br.com.estudos.drogaria.model.Produto;

public interface IprodutoService {
	
	Optional<Produto> getProdutoById(Short id) throws ProdutoException;
	Produto salvarProduto(Produto produto) throws ProdutoException;
}
