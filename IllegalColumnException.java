/**
 * Custom exception thrown when a number 
 * not in the interval [1,7] is entered for column.
 * @author Ece Camurlu
 */
public class IllegalColumnException extends Exception{
    public IllegalColumnException (String message) {
        super(message);
    }
}
