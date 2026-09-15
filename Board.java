import java.util.ArrayList;
/**
 * Backend logic for connect four game.
 * Manages the game by creating a 6×7 board (using arraylist), printing it, 
 * checking conditions to place a coin, and if the game is over or not.
 * @author Ece Camurlu
 */
public class Board {
    ArrayList <Character[]> board = new ArrayList <Character[]>();
    /**
     * This is the method to create the board which
     * will be updated for the rest of the game.
     * The row that is printed at the top has index 0,
     * the row at the bottom has index 5.
     * @return 6×7 board 
     */
    ArrayList<Character[]> createBoard() {
        for (int i = 0; i < 6; i++) {
            Character[] row = new Character[7];
            for (int j = 0; j < 7; j++){
                row[j] = '-';
            }
            board.add(i, row);
        }
        return board;
    }
    /**
     * This is the method to print the board to the terminal.
     */
    void printBoard(){
        for (int i=0; i<6; i++){
            Character[] tmp = board.get(i);
            for (int j=0; j<tmp.length; j++) {
                System.out.print(tmp[j]);
            }
            System.out.println();
        }
    }
    /**
     * This is the method to check if the coin can be dropped 
     * in the requested column and drop the coin if it is possible.
     * @param column the column requested by the player
     * @param player the shape which will be placed on the board
     * @throws ColumnFullException the custom exception thrown when the requested column is full
     * @throws IllegalColumnException the custom exception thrown when the requested column does not exist
     */
    void dropCoin (int column, char player) throws ColumnFullException, IllegalColumnException {
        if (column < 1 || column > 7) {
            throw new IllegalColumnException ("There is no column " + column);
        }
        //Since the 1. column has index 0, we must -1 to find the actual index of column.
        int actualColumn = column - 1;
        for (int i = 5; i > -1; i--){
            Character[] currentRow = board.get(i);
            if(currentRow[actualColumn] == '-') {
                currentRow[actualColumn] = player;
                if(checkWin(i, actualColumn, player) == true) {
                    System.out.println("The " + player + " wins!");
                }
                //ends the void method
                return;
            }
        }
        throw new ColumnFullException("The column is already full.");
    }
    /**
     * This is the method that checks if the game has been won. 
     * It checks vertically, horizontally and diagonally.
     * @param row the row which the last coin was placed in
     * @param column the column which the last coin was placed in
     * @param player the shape which we are checking for
     * @return true if the game is won, false otherwise.
     */
    boolean checkWin(int row, int column, char player){
        Character[] currentRow = board.get(row);
        //Horizontal win logic
        //The counter starts at 1 because we already have the last dropped coin.
        int counter = 1;
        int tempColumn = column;
        while (tempColumn <= 5 && currentRow[tempColumn + 1] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempColumn++;
        }
        tempColumn = column;
        while (tempColumn > 0 && currentRow[tempColumn - 1] == player){
            counter ++;
            if(counter == 4) {
                return true;
            }
            tempColumn--;
        }
        //Vertical win logic
        //Upwards is not checked since it is physically impossible.
        int tempRow = row;
        counter = 1;
        while (tempRow < 5 && board.get(tempRow + 1)[column] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempRow++;
        }
        //Diagonal win logic
        counter = 1;
        tempColumn = column;
        tempRow = row;
        while(tempRow < 5 && tempColumn > 0 && board.get(tempRow + 1)[tempColumn - 1] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempRow++;
            tempColumn--;
        }
        tempColumn = column;
        tempRow = row;
        while(tempColumn <= 5 && tempRow > 0 && board.get(tempRow - 1)[tempColumn + 1] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempRow--;
            tempColumn++;
        }
        counter = 1;
        tempColumn = column;
        tempRow = row;
        while(tempRow > 0 && tempColumn > 0 && board.get(tempRow - 1)[tempColumn - 1] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempRow--;
            tempColumn--;
        }
        tempColumn = column;
        tempRow = row;
        while(tempRow < 5 && tempColumn <= 5 && board.get(tempRow + 1)[tempColumn + 1] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempRow++;
            tempColumn++;
        }
        return false;
    }
}