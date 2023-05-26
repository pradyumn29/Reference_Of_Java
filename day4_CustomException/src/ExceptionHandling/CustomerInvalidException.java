package ExceptionHandling;

@SuppressWarnings("serial")
public class CustomerInvalidException extends Exception {

	public CustomerInvalidException(String msg) {
		super(msg);
	}

}
