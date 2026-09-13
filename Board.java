import java.util.ArrayList;
public class Board {
    ArrayList <Character[]> board = new ArrayList <Character[]>();
    ArrayList<Character[]> createBoard() {
        for (int i = 0; i < 6; i++) {
            Character[] row = new Character[7];
            for (int j = 0; j < 7; j++){
                row[j] = ' ';
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
}