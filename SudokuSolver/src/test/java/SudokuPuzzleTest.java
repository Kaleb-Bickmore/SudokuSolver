import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SudokuPuzzleTest {
    @Test
    public void getStrategiesUsed() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        ArrayList<String> strategiesUsed = new ArrayList<String>();
        myPuzzle.appendStrategy("Twist");
        assertEquals(new Integer(1),myPuzzle.getStrategiesUsed().get("Twist"));
    }


    @Test
    public void appendStrategy() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        myPuzzle.appendStrategy("Twist");
        assertEquals(new Integer(1),myPuzzle.getStrategiesUsed().get("Twist"));
    }

    @Test
    public void getTimeElasped() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        myPuzzle.addToTimeElasped(12);
        assertEquals(12,myPuzzle.getTimeElasped(),.0001);

    }

    @Test
    public void getBoardSize() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals(4,myPuzzle.getBoardSize(),.0001);

    }

    @Test
    public void getFileName() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("someDirectory\\SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals("SomeFile.txt",myPuzzle.getFileName().getName());

    }


    @Test
    public void getSolved() {

        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals(Boolean.FALSE,myPuzzle.getSolved());

    }

    @Test
    public void getPossibleToSolve() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals(Boolean.TRUE,myPuzzle.getPossibleToSolve());
        myPuzzle.setPossibleToSolve(Boolean.FALSE);
        assertEquals(Boolean.FALSE,myPuzzle.getSolved());

    }

    @Test
    public void getBoard() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals(myBoard,myPuzzle.getBoard());

    }

    @Test
    public void getSolvedBoard() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertNull(myPuzzle.getSolvedBoard());

    }

    @Test
    public void displayBoard() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        /**
         * Look to make sure that the board is in fact 4 rows of A B C D
         */
        myPuzzle.displayBoard();
    }

    @Test
    public void displaySolvedBoard() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        /**
        * this should not display anything since it is not solved yet
        */
        myPuzzle.displaySolvedBoard();
        /**
         * Look to make sure that the board is in fact 4 rows of A B C D
         */
        myPuzzle.setSolvedBoard(myBoard);
        myPuzzle.displaySolvedBoard();
    }

    @Test
    public void getPossibleBoardValues() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals(myHash,myPuzzle.getPossibleBoardValues());

    }

    @Test
    public void solvedBoardExport() {
        String[][]myBoard = new String[4][4];
        HashMap<String,String> myHash = new HashMap<String, String>();
        myHash.put("A","A");
        myHash.put("B","B");
        myHash.put("C","C");
        myHash.put("D","D");
        String myBoardFormatted = "A B C D \nA B C D \nA B C D \nA B C D \n";
        for(int i = 0; i<4;i++){
            myBoard[i] = new String[]{"A", "B", "C", "D"};
        }
        File myFile = new File("SomeFile.txt");
        SudokuPuzzle myPuzzle = new SudokuPuzzle(4,myBoard,myHash,myFile);
        assertEquals(myBoardFormatted+"NOT SOLVED YET",myPuzzle.solvedBoardExport());
        myPuzzle.setPossibleToSolve(Boolean.FALSE);
        assertEquals(myBoardFormatted+"BAD BOARD",myPuzzle.solvedBoardExport());
        myPuzzle.setSolvedBoard(myBoard);
        myPuzzle.appendStrategy("someStrategy");
        myPuzzle.appendStrategy("anotherStrategy");

        assertEquals(myBoardFormatted+"SOLVED: \n"+myBoardFormatted+ "TIME ELAPSED: 0 MILLISECONDS"
                        +"\n STRATEGIES USED: \n" +
                "someStrategy TIMES USED: 1\n" +
                "anotherStrategy TIMES USED: 1\n",myPuzzle.solvedBoardExport());


    }
}
