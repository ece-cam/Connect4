public class Main {
    public static void main (String[] args) {
        Board board = new Board();
        board.createBoard();
        board.printBoard();
        try{
            board.dropCoin(3, 'X');
            board.printBoard();
            board.dropCoin(4, 'X');
            board.printBoard();
            board.dropCoin(5, 'X');
            board.printBoard();
            board.dropCoin(6, 'X');
        } catch(ColumnFullException e){
            System.out.println("Try a new column.");
        } catch(IllegalColumnException e){
            System.out.println("This column does not exist.");
        }
        board.printBoard();
    }
}