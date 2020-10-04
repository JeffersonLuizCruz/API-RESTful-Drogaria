package br.com.estudos.drogaria.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudos.drogaria.Iservice.IprodutoService;
import br.com.estudos.drogaria.exception.ProdutoException;
import br.com.estudos.drogaria.model.Produto;
import br.com.estudos.drogaria.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements IprodutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Optional<Produto> getProdutoByNome(String nome) throws ProdutoException {
		Optional<Produto> buscarNome = produtoRepository.findByNome(nome);
		if(buscarNome.isEmpty()) {
			throw new ProdutoException("Produto não encontrado", "Campo Nome");
		}
		return buscarNome;
	}

	@Override
	public Optional<Produto> getProdutoById(Short id) throws Exception{
		Optional<Produto> buscarId = produtoRepository.findById(id);
		if(buscarId.isEmpty()) {
			throw new ProdutoException("Produto não encontrado", "Campo id");
		}
		return buscarId;
	}
	@Override
	public Optional<Produto> salvarProduto(Produto produto) throws ProdutoException {
		Optional<Produto> existeProduto = produtoRepository.findByNome(produto.getNome());
		if(existeProduto != null && !existeProduto.equals(produto)) {
			throw new ProdutoException("Produto já existe no sistema", "Campo Nome");
		}
		return existeProduto;
	}

}
