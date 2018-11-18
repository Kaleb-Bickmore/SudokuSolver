import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SudokuValidTest {
    @Test
    public void checkOnPuzzle() {
        HashMap<Boolean,SudokuSolvingStrategy> strategyPattern = new HashMap<Boolean, SudokuSolvingStrategy>();
        strategyPattern.put(Boolean.FALSE,new SudokuInvalid());
        strategyPattern.put(Boolean.TRUE,new SudokuValid());

        String[] row0 = {"8", "2", "6", "9", "3", "5", "1", "4", "7"};
        String[] row1 = {"7", "5", "1", "6", "8", "4", "2", "9", "3"};
        String[] row2 = {"3", "4", "9", "2", "1", "7", "5", "8", "6"};
        String[] row3 = {"1", "9", "2", "7", "4", "3", "6", "5", "8"};
        String[] row4 = {"4", "6", "7", "5", "9", "8", "3", "1", "2"};
        String[] row5 = {"5", "3", "8", "1", "6", "2", "9", "7", "4"};
        String[] row6 = {"6", "7", "3", "8", "5", "9", "4", "2", "1"};
        String[] row7 = {"2", "1", "5", "4", "7", "6", "8", "3", "9"};
        String[] row8 = {"9", "8", "4", "3", "2", "1", "7", "6", "5"};
        String[][] board = new String[9][9];
        board[0] = row0;
        board[1] = row1;
        board[2] = row2;
        board[3] = row3;
        board[4] = row4;
        board[5] = row5;
        board[6] = row6;
        board[7] = row7;
        board[8] = row8;
        int i = 1;
        String[] row10 = {"-", "2", "6", "9", "3", "5", "1", "4", "7"};
        String[] row11 = {"7", "5", "1", "6", "8", "4", "2", "9", "3"};
        String[] row12 = {"3", "4", "9", "2", "1", "7", "5", "8", "6"};
        String[] row13 = {"1", "9", "2", "7", "4", "3", "6", "5", "8"};
        String[] row14 = {"4", "6", "-", "5", "9", "8", "3", "1", "2"};
        String[] row15 = {"5", "3", "8", "1", "6", "2", "9", "7", "4"};
        String[] row16 = {"6", "7", "3", "8", "5", "9", "4", "2", "1"};
        String[] row17 = {"2", "1", "5", "4", "7", "6", "8", "3", "9"};
        String[] row18 = {"9", "8", "4", "3", "2", "1", "7", "6", "5"};
        String[][] otherBoard = new String[9][9];
        otherBoard[0] = row10;
        otherBoard[1] = row11;
        otherBoard[2] = row12;
        otherBoard[3] = row13;
        otherBoard[4] = row14;
        otherBoard[5] = row15;
        otherBoard[6] = row16;
        otherBoard[7] = row17;
        otherBoard[8] = row18;
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
        SudokuPuzzle myPuzzle = new SudokuPuzzle(9,board,possibleValues,new File("SomeFile.txt"));
        i = strategyPattern.get(Boolean.TRUE).checkOnPuzzle(myPuzzle,board,board,i);
        assertEquals(1,i,.00001);
        board[0][1]="-";
        SudokuPuzzle myPuzzle2 = new SudokuPuzzle(9,board,possibleValues,new File("SomeFile.txt"));
        i = strategyPattern.get(Boolean.TRUE).checkOnPuzzle(myPuzzle2,board,board,i);
        assertEquals(2,i,.00001);
        String[] invalidRow = {"1"};
        String[][]invalidBoard = new String[1][1];
        i = strategyPattern.get(Boolean.TRUE).checkOnPuzzle(myPuzzle,board,invalidBoard,i);
        assertEquals(2,i,.00001);
        board[7][8]="-";
        board[6][1]="-";
        board[0][6]="-";
        i = strategyPattern.get(Boolean.TRUE).checkOnPuzzle(myPuzzle,board,otherBoard,i);
        assertEquals(2,i,.00001);


    }
}