/**
 * Custom exception thrown when the column that
 *  was picked is full, no coins can be placed.
 * @author Ece Camurlu
 */
public class ColumnFullException extends Exception{
    public ColumnFullException (String message) {
        super(message);
    }
}
