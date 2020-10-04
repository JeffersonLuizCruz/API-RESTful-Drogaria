package br.com.estudos.drogaria.exception;

public class CategoriaException extends RuntimeException{

	private static final long serialVersionUID = 5426706917813669844L;
	
	private String campoException;
	
	public CategoriaException(String message, String campoException) {
		super(message);
		this.campoException = campoException;
	}
	
	public String getCampoException() {
		return this.campoException;
	}


}
