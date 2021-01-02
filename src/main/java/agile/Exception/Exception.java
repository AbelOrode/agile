package agile.Exception;

@SuppressWarnings("serial")
public class Exception extends RuntimeException{
	 private final String message;
	 
	    public Exception(String message) {
	        this.message = message;
	    }


	    public String getMessage() {
	        return message;
	    }
}
