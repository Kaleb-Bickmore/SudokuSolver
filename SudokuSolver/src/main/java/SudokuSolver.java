import java.util.ArrayList;
import java.util.HashMap;

public class SudokuSolver {
    private ArrayList<SudokuPuzzle> sudokuPuzzles;
    private HashMap<Integer,SolvingMethod> solvingStrategies;
    private HashMap<Boolean,SudokuSolvingStrategy> strategyPattern;

    public SudokuSolver(ArrayList<SudokuPuzzle> sudokuPuzzles){
        this.sudokuPuzzles = sudokuPuzzles;
        solvingStrategies = new HashMap<Integer,SolvingMethod>();
        solvingStrategies.put(1, new OnlyChoiceMethod());
        solvingStrategies.put(2,new TwinsMethod());
        solvingStrategies.put(3,new GuessMethod());
        strategyPattern = new HashMap<Boolean, SudokuSolvingStrategy>();
        strategyPattern.put(Boolean.FALSE,new SudokuInvalid());
        strategyPattern.put(Boolean.TRUE,new SudokuNotInvalid());

    }

    public ArrayList<SudokuPuzzle> solve() {
        ArrayList<SudokuPuzzle> solvedPuzzles= new ArrayList<SudokuPuzzle>();
        for (SudokuPuzzle myPuzzle: sudokuPuzzles) {
            int i = 1;
            int count =0;
            String[][] solvedBoard = myPuzzle.getBoard();
            System.out.println(myPuzzle.getFileName().getAbsolutePath());
            displayBoard(solvedBoard);
            if (SudokuChecker.checkPossibleValue(solvedBoard, myPuzzle.getPossibleBoardValues())&& SudokuChecker.validSudoku(solvedBoard)) {
                while (myPuzzle.getPossibleToSolve() && !myPuzzle.getSolved()) {
                    SolvingMethod methodToAttempt = solvingStrategies.get(i);
                    String[][] copySolvedBoard = new String[solvedBoard.length][solvedBoard.length];
                    for (int j = 0; j < solvedBoard.length; j++) {
                        copySolvedBoard[j] = solvedBoard[j].clone();
                    }
                    long startTime = System.nanoTime();

                    solvedBoard = methodToAttempt.solve(solvedBoard,myPuzzle.getPossibleBoardValues(),myPuzzle);
                    long endTime = System.nanoTime();
                    myPuzzle.addToTimeElasped(((endTime - startTime) / 1000));
                    i = strategyPattern.get(SudokuChecker.checkNotEmpty(solvedBoard)).checkOnPuzzle(myPuzzle,solvedBoard,copySolvedBoard,i);
                    count = count+1;

                if(count%10000==0){
                    System.out.println("myBoard");
                    displayBoard(solvedBoard);
                    System.out.println("things not to put in");

                    displayBoard(myPuzzle.getListOfIndexesTried());

                }
                }
                displayBoard(myPuzzle.getSolvedBoard());
                solvedPuzzles.add(myPuzzle);
            }
            else{
                displayBoard(solvedBoard);
                System.out.println("cannot be solved...");
                myPuzzle.setPossibleToSolve(Boolean.FALSE);;
                solvedPuzzles.add(myPuzzle);
            }
        }
        return solvedPuzzles;
    }

    private void displayBoard(String[][] solvedBoard) {
        System.out.println("----------------------");
       if(solvedBoard!=null) {
           for (int i = 0; i < solvedBoard.length; i++) {
               for (int j = 0; j < solvedBoard.length; j++) {
                   System.out.print(solvedBoard[i][j]);
               }
               System.out.println("");
           }
           System.out.println("----------------------");
       }
    }


    private int determineDifficulty(int boardSize,String[][] board) {
        double totalNumOfCells = boardSize*boardSize;
        double count = 0;
        for (int i = 0;i<boardSize;i++){
            for (int j = 0;j<boardSize;j++){
                if(!board[i][j].equals("-")){
                    count = count+1;
                }
            }
        }
        double ratioOfGivenToEmpty = count/totalNumOfCells;
        count = 0;
        for (int i = 0;i<boardSize;i++) {
            if(!board[0][i].equals("-")) {
                count = count+1;

            }
            }
        double ratioOfSpaceBetween = count/(double)boardSize;
        double normalizedScore = (ratioOfGivenToEmpty+ratioOfSpaceBetween)/2;
        if(normalizedScore<.33){
            return 5;
        }
        else if(normalizedScore <.38){
            return 4;
        }
        else if(normalizedScore <.43){
            return 3;
        }
        else if(normalizedScore <.48){
            return 2;
        }
        else{
            return 1;
        }
    }

    protected boolean compareBoards(String[][] firstBoard,String [] [] secondBoard){
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
}
