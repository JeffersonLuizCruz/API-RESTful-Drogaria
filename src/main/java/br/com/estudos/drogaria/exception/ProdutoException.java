package br.com.estudos.drogaria.exception;

public class ProdutoException extends Exception{

	private static final long serialVersionUID = -8838370787938689391L;
	
	private String exceptionCampo;
	
	public ProdutoException(String message, String exceptionCampo) {
		super(message);
		this.exceptionCampo = exceptionCampo;	
	}
	
	public String getExceptionCampo() {
		return this.exceptionCampo;
	}


}
