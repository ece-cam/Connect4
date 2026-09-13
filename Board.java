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
                return;
            }
        }
        throw new ColumnFullException("The column is already full.");
    }
}