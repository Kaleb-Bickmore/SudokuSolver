import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SudokuInvalidTest {

    @Test
    public void checkOnPuzzle() {
        HashMap<Boolean,SudokuSolvingStrategy> strategyPattern = new HashMap<Boolean, SudokuSolvingStrategy>();
        strategyPattern.put(Boolean.FALSE,new SudokuInvalid());
        strategyPattern.put(Boolean.TRUE,new SudokuValid());
        String[] row01 = {"_", "2", "6", "9", "3", "5", "1", "4", "7"};
        String[] row11 = {"7", "5", "_", "6", "8", "4", "2", "9", "3"};
        String[] row21 = {"3", "_", "9", "2", "1", "7", "5", "8", "6"};
        String[] row31 = {"1", "9", "2", "7", "4", "3", "6", "5", "8"};
        String[] row41 = {"4", "6", "7", "5", "9", "8", "3", "1", "2"};
        String[] row51 = {"5", "3", "8", "1", "6", "2", "9", "7", "4"};
        String[] row61 = {"6", "7", "3", "8", "5", "9", "4", "2", "1"};
        String[] row71 = {"2", "1", "5", "4", "7", "6", "8", "3", "9"};
        String[] row81 = {"9", "8", "4", "3", "2", "1", "7", "6", "5"};
        String[][] PreviousState = new String[9][9];
        PreviousState[0] = row01;
        PreviousState[1] = row11;
        PreviousState[2] = row21;
        PreviousState[3] = row31;
        PreviousState[4] = row41;
        PreviousState[5] = row51;
        PreviousState[6] = row61;
        PreviousState[7] = row71;
        PreviousState[8] = row81;

        String[] row0 = {"", "2", "6", "9", "3", "5", "1", "4", "7"};
        String[] row1 = {"7", "5", "1", "6", "8", "4", "2", "9", "3"};
        String[] row2 = {"3", "", "9", "2", "1", "7", "5", "8", "6"};
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
        myPuzzle.saveState(PreviousState);
        myPuzzle.addToIndexesNotInBoard(1,2,"6");
        i = strategyPattern.get(Boolean.FALSE).checkOnPuzzle(myPuzzle,board,board,2);
        assertEquals(1,i,.00001);
        i = strategyPattern.get(Boolean.TRUE).checkOnPuzzle(myPuzzle,board,board,2);
        assertEquals(2,i,.00001);
         i = strategyPattern.get(Boolean.FALSE).checkOnPuzzle(myPuzzle,board,board,2);
        assertEquals(2,i,.00001);
    }
}