package HashMap;

import java.util.HashSet;
/**
 * Created by tharun on 12/21/16.
 */

class ValidSudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++){
            HashSet<Character> rowSet = new HashSet<Character>();
            HashSet<Character> colSet = new HashSet<Character>();
            HashSet<Character> miniSquareSet = new HashSet<Character>();
            for (int j = 0; j < n; j++){
                // Check rows are unique
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) return false;
                // Check columns are unique
                if (board[j][i] != '.' && !colSet.add(board[j][i])) return false;
                // Check if internal square is unique
                if (board[3*(i/3) + j/3][3*(i%3) + j%3] != '.' && !miniSquareSet.add(board[3*(i/3) + j/3][3*(i%3) + j%3])) return false;
            }
        }
        return true;
    }
}

public class ValidSudoku {
    public static void main (String[] args){
        String[] input = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        char[][] board = new char[9][9];
        int i = 0;
        for (String row : input){
            board[i++] = row.toCharArray();
        }
        ValidSudokuSolution s = new ValidSudokuSolution();
        System.out.println(s.isValidSudoku(board));
    }
}
