import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SudokuCheckerTest {

    @Test
    public void checkCellsFilled() {

        String [] row0 = {"8","2","6","9","3","5","1","4","7"};
        String [] row1 = {"7","5","1","6","8","4","2","9","3"};
        String [] row2 = {"3","4","9","2","1","7","5","8","6"};
        String [] row3 = {"1","9","2","7","4","3","6","5","8"};
        String [] row4 = {"4","6","7","5","9","8","3","1","2"};
        String [] row5 = {"5","3","8","1","6","2","9","7","4"};
        String [] row6 = {"6","7","3","8","5","9","4","2","1"};
        String [] row7 = {"2","1","5","4","7","6","8","3","9"};
        String [] row8 = {"9","8","4","3","2","1","7","6","5"};
        String [][] board = new String[9][9];
        board[0]= row0;
        board[1]= row1;
        board[2]= row2;
        board[3]= row3;
        board[4]= row4;
        board[5]= row5;
        board[6]= row6;
        board[7]= row7;
        board[8]= row8;
        assertEquals(Boolean.TRUE,SudokuChecker.checkCellsFilled(board));
        board[0][2]="-";
        board[1][3]="-";
        board[6][7]="-";
        board[5][4]="-";
        assertEquals(Boolean.FALSE,SudokuChecker.checkCellsFilled(board));
        board[0][2]="";
        board[1][3]="";
        board[6][7]="";
        board[5][4]="";
        assertEquals(Boolean.FALSE,SudokuChecker.checkCellsFilled(board));

    }

    @Test
    public void checkPossibleValue() {
        String [] row0 = {"8","2","6","9","3","5","1","4","7"};
        String [] row1 = {"7","5","1","6","8","4","2","9","3"};
        String [] row2 = {"3","4","9","2","1","7","5","8","6"};
        String [] row3 = {"1","9","2","7","4","3","6","5","8"};
        String [] row4 = {"4","6","7","5","9","8","3","1","2"};
        String [] row5 = {"5","3","8","1","6","2","9","7","4"};
        String [] row6 = {"6","7","3","8","5","9","4","2","1"};
        String [] row7 = {"2","1","5","4","7","6","8","3","9"};
        String [] row8 = {"9","8","4","3","2","1","7","6","5"};
        String [][] board = new String[9][9];
        board[0]= row0;
        board[1]= row1;
        board[2]= row2;
        board[3]= row3;
        board[4]= row4;
        board[5]= row5;
        board[6]= row6;
        board[7]= row7;
        board[8]= row8;
        HashMap<String,String> possibleValues = new HashMap<String, String>();
        possibleValues.put("1","1");
        possibleValues.put("2","2");
        possibleValues.put("3","3");
        possibleValues.put("4","4");
        possibleValues.put("5","5");
        possibleValues.put("6","6");
        possibleValues.put("7","7");
        possibleValues.put("8","8");
        possibleValues.put("9","9");
        assertEquals(Boolean.TRUE,SudokuChecker.checkPossibleValue(board,possibleValues));
        board[0][2]="-";
        board[1][3]="-";
        board[6][7]="-";
        board[5][4]="-";
        assertEquals(Boolean.TRUE,SudokuChecker.checkPossibleValue(board,possibleValues));
        board[0][2]="W";
        board[1][3]="V";
        board[6][7]="13";
        board[5][4]="12";
        assertEquals(Boolean.FALSE,SudokuChecker.checkPossibleValue(board,possibleValues));
        board[0][2]="";
        board[1][3]="";
        board[6][7]="";
        board[5][4]="";
        assertEquals(Boolean.FALSE,SudokuChecker.checkPossibleValue(board,possibleValues));
    }

    @Test
    public void validSudoku() {
        String [] row0 = {"8","2","6","9","3","5","1","4","7"};
        String [] row1 = {"7","5","1","6","8","4","2","9","3"};
        String [] row2 = {"3","4","9","2","1","7","5","8","6"};
        String [] row3 = {"1","9","2","7","4","3","6","5","8"};
        String [] row4 = {"4","6","7","5","9","8","3","1","2"};
        String [] row5 = {"5","3","8","1","6","2","9","7","4"};
        String [] row6 = {"6","7","3","8","5","9","4","2","1"};
        String [] row7 = {"2","1","5","4","7","6","8","3","9"};
        String [] row8 = {"9","8","4","3","2","1","7","6","5"};
        String [][] board = new String[9][9];
        board[0]= row0;
        board[1]= row1;
        board[2]= row2;
        board[3]= row3;
        board[4]= row4;
        board[5]= row5;
        board[6]= row6;
        board[7]= row7;
        board[8]= row8;
    //assertEquals(Boolean.TRUE,SudokuChecker.validSudoku(board));
        board[0][2]="-";
        board[1][3]="-";
        board[6][7]="-";
        board[5][4]="-";
        board[3][7]="-";
        board[7][2]="-";

      assertEquals(Boolean.TRUE,SudokuChecker.validSudoku(board));
      board[7][7]="5";
      assertEquals(Boolean.FALSE,SudokuChecker.validSudoku(board));
      board[7][7]="3";
      assertEquals(Boolean.TRUE,SudokuChecker.validSudoku(board));
       board[6][0]="1";
       assertEquals(Boolean.FALSE,SudokuChecker.validSudoku(board));
       board[6][0]="6";
       assertEquals(Boolean.TRUE,SudokuChecker.validSudoku(board));
       board[7][1]="7";
       assertEquals(Boolean.FALSE,SudokuChecker.validSudoku(board));
       board[7][1]="1";
       assertEquals(Boolean.TRUE,SudokuChecker.validSudoku(board));

       board[7][8]="2";
        board[4][8]="-";
        assertEquals(Boolean.FALSE,SudokuChecker.validSudoku(board));
        board[7][8]="-";
        assertEquals(Boolean.TRUE,SudokuChecker.validSudoku(board));
       board[0][2]="";
       board[1][3]="";
       board[6][7]="";
       board[5][4]="";
       assertEquals(Boolean.FALSE,SudokuChecker.validSudoku(board));

    }

    @Test
    public void checkNotEmpty() {
        String [] row0 = {"8","2","6","9","3","5","1","4","7"};
        String [] row1 = {"7","5","1","6","8","4","2","9","3"};
        String [] row2 = {"3","4","9","2","1","7","5","8","6"};
        String [] row3 = {"1","9","2","7","4","3","6","5","8"};
        String [] row4 = {"4","6","7","5","9","8","3","1","2"};
        String [] row5 = {"5","3","8","1","6","2","9","7","4"};
        String [] row6 = {"6","7","3","8","5","9","4","2","1"};
        String [] row7 = {"2","1","5","4","7","6","8","3","9"};
        String [] row8 = {"9","8","4","3","2","1","7","6","5"};
        String [][] board = new String[9][9];
        board[0]= row0;
        board[1]= row1;
        board[2]= row2;
        board[3]= row3;
        board[4]= row4;
        board[5]= row5;
        board[6]= row6;
        board[7]= row7;
        board[8]= row8;
        assertEquals(Boolean.TRUE,SudokuChecker.checkNotEmpty(board));
        board[0][2]="-";
        board[1][3]="-";
        board[6][7]="-";
        board[5][4]="-";
        assertEquals(Boolean.TRUE,SudokuChecker.checkNotEmpty(board));
        board[0][2]="";
        board[1][3]="";
        board[6][7]="";
        board[5][4]="";
        assertEquals(Boolean.FALSE,SudokuChecker.checkNotEmpty(board));
    }
    private void displayBoard(String[][] solvedBoard) {
        System.out.println("----------------------");
        for (int i = 0; i < solvedBoard.length; i++) {
            for (int j = 0; j < solvedBoard.length; j++) {
                System.out.print(solvedBoard[i][j]);
            }
            System.out.println("");
        }
        System.out.println("----------------------");
    }

}