package Exceptions;

public class NoHayException extends Exception{
	
	private final static long serialVersionUID = 1000L;
	
	public NoHayException(String mensaje, Exception e)
	{
		super(mensaje, e);
	}
}
