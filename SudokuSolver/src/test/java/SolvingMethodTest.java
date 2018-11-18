import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class SolvingMethodTest {

    @Test
    public void solve() {
        SolvingMethod onlyChoiceMethod = new OnlyChoiceMethod();
        assertEquals("OnlyChoice",onlyChoiceMethod.toString());

        File [] inputFiles= new File[1];
        inputFiles[0] = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input\\Puzzle-9x9-0201.txt");
        SudokuLoader myLoader =  new SudokuLoader(inputFiles);
        ArrayList<SudokuPuzzle> myPuzzle = myLoader.load();
        String[][] puzzle = onlyChoiceMethod.solve(myPuzzle.get(0).getBoard(),myPuzzle.get(0).getPossibleBoardValues(),myPuzzle.get(0));
        assertEquals(Boolean.FALSE,compareBoards(myPuzzle.get(0).getBoard(),puzzle));
        SolvingMethod guessMethod = new GuessMethod();
        assertEquals("BackTrack",guessMethod.toString());
        String[][] solvedPuzzle = guessMethod.solve(myPuzzle.get(0).getBoard(),myPuzzle.get(0).getPossibleBoardValues(),myPuzzle.get(0));
        solvedPuzzle = guessMethod.solve(myPuzzle.get(0).getBoard(),myPuzzle.get(0).getPossibleBoardValues(),myPuzzle.get(0));
        solvedPuzzle = guessMethod.solve(solvedPuzzle,myPuzzle.get(0).getPossibleBoardValues(),myPuzzle.get(0));
        solvedPuzzle = guessMethod.solve(solvedPuzzle,myPuzzle.get(0).getPossibleBoardValues(),myPuzzle.get(0));
        String [] row0 = {"8","2","6","9","-","5","-","-","7"};
        String [] row1 = {"-","-","-","6","8","-","-","9","-"};
        String [] row2 = {"3","-","9","-","-","-","-","-","-"};
        String [] row3 = {"-","-","-","-","-","3","-","-","8"};
        String [] row4 = {"4","-","7","-","9","-","3","-","2"};
        String [] row5 = {"5","-","-","1","-","-","-","-","-"};
        String [] row6 = {"-","-","-","-","-","-","4","-","1"};
        String [] row7 = {"2","1","-","-","7","6","-","-","-"};
        String [] row8 = {"9","-","-","3","-","-","-","6","-"};
    displayBoard(solvedPuzzle);
        displayBoard(myPuzzle.get(0).getBoard());

        assertArrayEquals(solvedPuzzle[0],solvedPuzzle[0]);
        assertArrayEquals(solvedPuzzle[1],solvedPuzzle[1]);
        assertArrayEquals(solvedPuzzle[2],solvedPuzzle[2]);
        assertArrayEquals(solvedPuzzle[3],solvedPuzzle[3]);
        assertArrayEquals(solvedPuzzle[4],solvedPuzzle[4]);
        assertArrayEquals(solvedPuzzle[5],solvedPuzzle[5]);
        assertArrayEquals(solvedPuzzle[6],solvedPuzzle[6]);
        assertArrayEquals(solvedPuzzle[7],solvedPuzzle[7]);
        assertArrayEquals(solvedPuzzle[8],solvedPuzzle[8]);
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
        String [] row10 = {"1","2","3","-","-","-","-","-","-"};
        String [] row11 = {"-","7","5","4","-","-","-","-","9"};
        String [] row12 = {"8","4","6","-","-","-","-","-","-"};
        String [] row13 = {"7","-","-","-","-","-","-","-","-"};
        String [] row14 = {"6","-","-","-","-","-","-","-","-"};
        String [] row15 = {"5","-","-","-","-","-","-","-","-"};
        String [] row16 = {"4","-","-","-","-","-","-","-","-"};
        String [] row17 = {"3","-","-","-","-","-","-","-","-"};
        String [] row18 = {"2","-","-","-","-","-","-","-","-"};
        String [][] guessBoard = new String[9][9];
        guessBoard [0]= row10;
        guessBoard [1]= row11;
        guessBoard [2]= row12;
        guessBoard [3]= row13;
        guessBoard [4]= row14;
        guessBoard [5]= row15;
        guessBoard [6]= row16;
        guessBoard [7]= row17;
        guessBoard [8]= row18;
        SudokuPuzzle newPuzzle = new SudokuPuzzle(9,guessBoard,possibleValues,new File("someFile.txt"));
        String[][] badPuzzle = guessMethod.solve(guessBoard,newPuzzle.getPossibleBoardValues(),newPuzzle);
        assertEquals(Boolean.FALSE,SudokuChecker.checkNotEmpty(badPuzzle));
    }

    @Test
    public void useTwinsToEliminate() {
        SolvingMethod myTwin = new TwinsMethod();
        assertEquals("Twins",myTwin.toString());

        String [] row0 = {"6","3","9","-","-","8","-","-","4"};
        String [] row1 = {"-","8","7","-","-","4","-","-","9"};
        String [] row2 = {"-","2","4","-","-","-","3","8","-"};
        String [] row3 = {"-","-","5","-","8","6","7","2","1"};
        String [] row4 = {"-","-","8","1","-","2","4","-","-"};
        String [] row5 = {"2","1","6","4","5","7","8","9","3"};
        String [] row6 = {"-","5","3","8","-","-","6","-","-"};
        String [] row7 = {"8","6","1","7","-","-","9","-","-"};
        String [] row8 = {"9","-","2","6","-","-","1","-","8"};
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
        String [] row10 = {"","","","","","","","",""};
        String [] row11 = {"","","","","","","","",""};
        String [] row12 = {"","","","","","","","",""};
        String [] row13 = {"","","","","","","","",""};
        String [] row14 = {"","","","","","","","",""};
        String [] row15 = {"","","","","","","","",""};
        String [] row16 = {"","","","","","","","",""};
        String [] row17 = {"","","","","","","","",""};
        String [] row18 = {"","","","","","","","",""};
        String [][] guessBoard = new String[9][9];
        guessBoard [0]= row10;
        guessBoard [1]= row11;
        guessBoard [2]= row12;
        guessBoard [3]= row13;
        guessBoard [4]= row14;
        guessBoard [5]= row15;
        guessBoard [6]= row16;
        guessBoard [7]= row17;
        guessBoard [8]= row18;
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
        String [][] originalBoard= new String[9][9];
        for(int i=0;i<9;i++){
            originalBoard[i]= board[i].clone();
        }
        board = myTwin.fillBoardWithPossibleValues(9,board,possibleValues,guessBoard);
        board = myTwin.useTwinsToElimnate(board,possibleValues);
        board = myTwin.fillWithDashes(9,board);
        displayBoard(board);
        assertEquals(false,compareBoards(originalBoard,board));

        String [] row101 = {"-","1","3","-","-","-","-","-","9"};
        String [] row111 = {"5","-","6","-","-","-","-","-","-"};
        String [] row121 = {"2","4","-","-","-","9","-","-","-"};
        String [] row131 = {"-","-","-","-","-","-","-","-","-"};
        String [] row141 = {"-","-","-","-","-","-","-","-","-"};
        String [] row151 = {"-","-","-","-","-","-","-","-","-"};
        String [] row161 = {"-","-","-","-","-","-","-","-","-"};
        String [] row171 = {"-","-","-","-","-","-","-","-","-"};
        String [] row181 = {"-","-","-","-","-","-","-","-","-"};
        String [][] squareTestBoard = new String[9][9];
        squareTestBoard [0]= row101;
        squareTestBoard [1]= row111;
        squareTestBoard [2]= row121;
        squareTestBoard [3]= row131;
        squareTestBoard [4]= row141;
        squareTestBoard [5]= row151;
        squareTestBoard [6]= row161;
        squareTestBoard [7]= row171;
        squareTestBoard [8]= row181;
        SudokuPuzzle squarePuzzleTwin = new SudokuPuzzle(9,squareTestBoard,possibleValues,new File("someOtherFile.txt"));
        String[][] solveBoard = myTwin.solve(squareTestBoard,possibleValues,squarePuzzleTwin);

        String [] row1011 = {"-","1","3","-","-","-","-","-","9"};
        String [] row1111 = {"5","9","6","-","-","-","-","-","-"};
        String [] row1211 = {"2","4","-","-","-","9","-","-","-"};
        String [] row1311 = {"-","-","-","-","-","-","-","-","-"};
        String [] row1411 = {"-","-","-","-","-","-","-","-","-"};
        String [] row1511 = {"-","-","-","-","-","-","-","-","-"};
        String [] row1611 = {"-","-","-","-","-","-","-","-","-"};
        String [] row1711 = {"-","-","-","-","-","-","-","-","-"};
        String [] row1811 = {"-","-","-","-","-","-","-","-","-"};
        String [][] testSquareTestBoard = new String[9][9];
        testSquareTestBoard [0]= row1011;
        testSquareTestBoard [1]= row1111;
        testSquareTestBoard [2]= row1211;
        testSquareTestBoard [3]= row1311;
        testSquareTestBoard [4]= row1411;
        testSquareTestBoard [5]= row1511;
        testSquareTestBoard [6]= row1611;
        testSquareTestBoard [7]= row1711;
        testSquareTestBoard [8]= row1811;
        assertEquals(Boolean.TRUE,compareBoards(testSquareTestBoard,solveBoard));
    }

    private boolean compareBoards(String[][] firstBoard,String [] [] secondBoard){
        if(firstBoard.length!=secondBoard.length){
            return Boolean.FALSE;
        }
        for(int i = 0; i <firstBoard.length;i++){
            for(int j=0;j<firstBoard[i].length;j++){
                if(!firstBoard[i][j].equals(secondBoard[i][j])){
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }
    private void displayBoard(String[][] solvedBoard) {
        System.out.println("----------------------");
        for (int i = 0; i < solvedBoard.length; i++) {
            for (int j = 0; j < solvedBoard.length; j++) {
                System.out.print(solvedBoard[i][j]+"  ");
            }
            System.out.println("");
        }
        System.out.println("----------------------");

    }
}