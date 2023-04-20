package reserva_api.services.exceptions;

public class AllPropertiesIsRequiredException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AllPropertiesIsRequiredException() {
		super("Todas as propriedades do objeto precisam ser prenchidas");
	}

}
