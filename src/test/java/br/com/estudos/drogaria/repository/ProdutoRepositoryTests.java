package br.com.estudos.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.estudos.drogaria.model.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	
	@Autowired
	ProdutoRepository produtorepository;
	
	@Test
	public void inserir() {
		Produto p1 = new Produto(null, "Miojo", Short.valueOf("15"), BigDecimal.valueOf(1.50),
								 LocalDate.of(2020, 3, 14), null);
		
		Produto p2 = new Produto(null, "Treloso", Short.valueOf("10"), BigDecimal.valueOf(1),
				 LocalDate.of(2020, 3, 14), null);
		produtorepository.save(p1);
		produtorepository.save(p2);
	}
}
