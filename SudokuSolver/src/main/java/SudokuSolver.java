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
        strategyPattern.put(Boolean.TRUE,new SudokuValid());

    }

    public ArrayList<SudokuPuzzle> solve() {
        ArrayList<SudokuPuzzle> solvedPuzzles= new ArrayList<SudokuPuzzle>();
        for (SudokuPuzzle myPuzzle: sudokuPuzzles) {
            int i = 1;
            String[][] solvedBoard = myPuzzle.getBoard();
            System.out.println(myPuzzle.getFileName().getAbsolutePath());
            displayBoard(solvedBoard);
            if (SudokuChecker.checkPossibleValue(solvedBoard, myPuzzle.getPossibleBoardValues())) {
                if(SudokuChecker.validSudoku(solvedBoard)){
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

                }
                displayBoard(myPuzzle.getSolvedBoard());
                solvedPuzzles.add(myPuzzle);
            }else {
                    displayBoard(solvedBoard);
                    System.out.println("Bad sudoku board");
                    myPuzzle.setPossibleToSolve(Boolean.FALSE);;
                    solvedPuzzles.add(myPuzzle);
                }
            }

            else{
                displayBoard(solvedBoard);
                System.out.println("Sudoku has Invalid Numbers");
                myPuzzle.setPossibleToSolve(Boolean.FALSE);
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

}
