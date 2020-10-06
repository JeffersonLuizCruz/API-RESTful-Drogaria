package br.com.estudos.drogaria.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudos.drogaria.Iservice.IcategoriaService;
import br.com.estudos.drogaria.exception.CategoriaException;
import br.com.estudos.drogaria.model.Categoria;
import br.com.estudos.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService implements IcategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> getCategoriaById(Short id) {
		Optional<Categoria> buscaId = categoriaRepository.findById(id);
		if(buscaId.isEmpty()) {
			throw new CategoriaException("Categoria por id não encontrada", "campo id");
		}
		return buscaId;
	}

	@Override
	public Categoria salvarCategoria(Categoria categoria) throws CategoriaException{
		Categoria existeCategoria = categoriaRepository.findByNome(categoria.getNome());
		if(existeCategoria != null && !existeCategoria.equals(categoria)) {
			throw new CategoriaException("Categoria já existe", "Campo nome");
		}
		return categoriaRepository.save(existeCategoria);
	}

}
