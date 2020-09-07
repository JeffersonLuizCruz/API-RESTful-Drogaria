package br.com.estudos.drogaria.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTests {
	@Test
	public void criar() {
		Produto p = new Produto(Short.valueOf("1"), "Miojo", Short.valueOf("15"),
								BigDecimal.valueOf(1.5), LocalDate.of(2021, 3, 14), null);
		
		System.out.println(p.toString());
	}


}
