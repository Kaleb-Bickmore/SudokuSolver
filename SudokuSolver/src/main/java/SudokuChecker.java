import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.HashMap;

public class SudokuChecker {
    /**
     * checks to see if every cell has a number
     * This is used to verify we have finished solving the sudoku board
     * @param board the sudoku board
     * @return
     */
    public static boolean checkCellsFilled(String[][] board){
        for(int i = 0; i <board.length;i++){
            for(int j = 0; j <board.length;j++) {
                if (board[i][j].equals("-") || board[i][j].equals("")||(board[i][j].split("-").length>1)) {
                    return Boolean.FALSE;
                }
                }
            }
        return Boolean.TRUE;
    }

    /**
     * this function validates that the sudoku board only has the values that are possible for this sudoku board
     * @param board the sudoku board
     * @param possibleValues possible values that the sudoku board can have
     * @return
     */
    public static boolean checkPossibleValue(String[][] board,HashMap<String,String> possibleValues){
        for (int i = 0; i<board.length;i++){
            for (int j = 0; j<board.length;j++){
                if(!board[i][j].equals("-")){
                    if(!possibleValues.containsKey(board[i][j])){
                        return Boolean.FALSE;
                    }
                }
            }
        }
        return Boolean.TRUE;
    }

    /**
     * Makes sure that we have a valid sudoku board with one number being in one row, column, and square
     * @param board the sudoku board
     * @return
     */
    public static boolean validSudoku(String[][] board) {
        int squareXStartingIndex = 0;
        int squareYStartingIndex = 0;
        int sizeOfSquare = (int)Math.sqrt(board.length);

        for(int i = 0; i <board.length;i++){
            if(i%sizeOfSquare == 0){
                squareXStartingIndex = i;
            }
            for (int j = 0; j< board.length;j++){
                if(j%sizeOfSquare == 0){
                    squareYStartingIndex = j;
                }
                if(!board[i][j].equals("-")){
                    if(!checkValidEntry(board,i,j,board[i][j],sizeOfSquare,squareXStartingIndex,squareYStartingIndex)){
                        return Boolean.FALSE;
                    }
                }

            }
        }
        return Boolean.TRUE;
    }

    /**
     * makes sure we have no empty spots on our  board
     * @param board the sudoku board
     * @return
     */
    public static boolean checkNotEmpty(String[][] board){
        for(int i = 0; i <board.length;i++){
            for(int j = 0; j <board.length;j++) {
                if (board[i][j].equals("")) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    /**
     * looks at one spot on the sudoku board, which is a number, and verifies no other number is in its square, column
     * and row
     * @param board the sudoku board
     * @param i the row index of our number
     * @param j the column index of our number
     * @param value the number associated with the board[i][j]
     * @param squareSize the size of the square that is to be used
     * @param squareX the starting row of the square
     * @param squareY the starting column of the square
     * @return
     */
    public static boolean checkValidEntry(String[][] board,int i,int j,String value,int squareSize,int squareX,int squareY){
        if(value.equals("")){
            return  Boolean.FALSE;
        }
        String[] myRow = board[i];
        String [] myCol = new String[board.length];
        for(int k = 0; k < board.length;k++){
            myCol[k] = board[k][j];

        }
        for(int l = 0;l<myRow.length;l++){

            if(myRow[l].equals(value)&&l!=j){

                //System.out.println("another one in the row");
                return Boolean.FALSE;
            }
            if(myCol[l].equals(value)&&l!=i){
                //System.out.println("another one in the col");
                return Boolean.FALSE;

            }
        }
        for(int m = squareX;m<squareX+squareSize;m++){

            for(int n = squareY;n<squareY+squareSize;n++){

                if(board[m][n].equals(value)) {
                    if (m != i || n != j) {
                        //    System.out.println("another one in the box");
                        return Boolean.FALSE;
                    }
                }
            }
        }

        return Boolean.TRUE;
    }
}
