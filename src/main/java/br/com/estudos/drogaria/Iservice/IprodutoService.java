package br.com.estudos.drogaria.Iservice;

import java.util.Optional;

import br.com.estudos.drogaria.exception.ProdutoException;
import br.com.estudos.drogaria.model.Produto;

public interface IprodutoService {
	Optional<Produto> getProdutoByNome(String nome) throws ProdutoException;
	Optional<Produto> getProdutoById(Short id) throws Exception;
	Optional<Produto> salvarProduto(Produto produto) throws ProdutoException;

}
