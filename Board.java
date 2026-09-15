import java.util.ArrayList;
public class Board {
    ArrayList <Character[]> board = new ArrayList <Character[]>();
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
    void printBoard(){
        for (int i=0; i<6; i++){
            Character[] tmp = board.get(i);
            for (int j=0; j<tmp.length; j++) {
                System.out.print(tmp[j]);
            }
            System.out.println();
        }
    }
    void dropCoin (int column, char player) throws ColumnFullException, IllegalColumnException {
        if (column < 1 || column > 7) {
            throw new IllegalColumnException ("There is no column " + column);
        }
        int actualColumn = column - 1;
        for (int i = 5; i > -1; i--){
            Character[] currentRow = board.get(i);
            if(currentRow[actualColumn] == '-') {
                currentRow[actualColumn] = player;
                if(checkWin(i, actualColumn, player) == true) {
                    System.out.println("The " + player + " wins!");
                }
                return;
            }
        }
        throw new ColumnFullException("The column is already full.");
    }
    boolean checkWin(int row, int column, char player){
        Character[] currentRow = board.get(row);
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
        int tempRow = row;
        counter = 1;
        while (tempRow < 5 && board.get(tempRow + 1)[column] == player) {
            counter++;
            if(counter == 4) {
                return true;
            }
            tempRow++;
        }
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