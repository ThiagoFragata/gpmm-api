package reserva_api.services.exceptions;

public class NonFreeResourceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NonFreeResourceException(Object codigo) {
		super("Recurso de id " + codigo + " não está livre no período selecionado");
	}
}
