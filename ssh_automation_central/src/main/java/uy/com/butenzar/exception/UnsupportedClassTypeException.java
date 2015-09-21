package uy.com.butenzar.exception;

/**
 * Exception para el manejo de tipos de clase para las cuales no hay una
 * implementación de código.
 * @author Bruno Szilagyi
 */
public class UnsupportedClassTypeException extends Exception {
    
    private String message = null;
 
    /**
     * asdasd
     */
    public UnsupportedClassTypeException() {
        super();
    }
 
    public UnsupportedClassTypeException(String message) {
        super(message);
        this.message = message;
    }
 
    public UnsupportedClassTypeException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
