import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a single Sudoku board in all its glory.
 * The Sudoku board keeps track of its own state. the user can set these
 * states through setter functions. Once we give the board a solution to the board,
 * it updates that it can be solved, and that it has been solved.
 */
public class SudokuPuzzle {
    /**
     * LOCAL VARIABLES
     */
    private int boardSize;
    private HashMap<String,Integer> strategiesUsed;
    private long timeElasped;
    private Boolean solved;
    private Boolean possibleToSolve;
    private String[][] board;
    private HashMap<String,String> possibleBoardValues;
    private File fileName;
    private String[][] solvedBoard;

    /**
     *
     * @param boardSize the size of our board
     * @param board the board itself
     * @param possibleBoardValues the list of values the board can contain
     * @param fileName the filename where the board was read from
     */
    public SudokuPuzzle(int boardSize,String[][] board,HashMap<String,String> possibleBoardValues,File fileName){
        this.board = board;
        this.fileName = fileName;
        this.boardSize = boardSize;
        this.possibleBoardValues = possibleBoardValues;
        this.possibleToSolve = true;
        this.solved = false;
        this.strategiesUsed = new HashMap<String, Integer>();
        this.timeElasped = 0;
    }

    /**
     *
     * @return the list of strategies used
     */
    public HashMap<String,Integer> getStrategiesUsed() {
        return strategiesUsed;
    }

    /**
     * set the strategy to an arraylist of strategies
     * @param strategiesUsed
     */
    public void setStrategiesUsed(HashMap<String,Integer> strategiesUsed) {
        this.strategiesUsed = strategiesUsed;
    }

    /**
     *
     * @param strategyUsed a single strategy used to solve the board
     */
    public void appendStrategy(String strategyUsed){
        if(this.strategiesUsed.containsKey(strategyUsed)){
            int count = this.strategiesUsed.get(strategyUsed);
            this.strategiesUsed.remove(strategyUsed);
            this.strategiesUsed.put(strategyUsed,count+1);
        }
        else {
            this.strategiesUsed.put(strategyUsed,1);
        }
        }

    /**
     *
     * @return total time elapsed solving the board
     */
    public double getTimeElasped() {
        return timeElasped;
    }

    /**
     *
     * @return the size of the board
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     *
     * @return the filename where this was read from
     */
    public File getFileName(){
        return  fileName;
    }

    /**
     * adds to the time elasped in solving it
     * @param timeElasped the time to add
     */
    public void addToTimeElasped(long timeElasped) {
        this.timeElasped = this.timeElasped + timeElasped;
    }

    /**
     *
     * @return whether or not the board has been solved
     */
    public Boolean getSolved() {
        return solved;
    }

    /**
     *
     * @return whether or not the board can be solved
     */
    public Boolean getPossibleToSolve() {
        return possibleToSolve;
    }

    /**
     * Set whether the board is possible to solve or not
     * @param possibleToSolve
     */
    public void setPossibleToSolve(Boolean possibleToSolve) {
        this.possibleToSolve = possibleToSolve;
    }

    /**
     *
     * @return the original board
     */
    public String[][] getBoard() {
        String [][] copyOriginalBoard = new String[boardSize][boardSize];
        for (int i = 0; i <boardSize;i++){
            copyOriginalBoard[i] = board[i].clone();
        }
        return copyOriginalBoard;
    }

    /**
     *
     * @return the solved board
     */
    public String[][] getSolvedBoard() {
        return solvedBoard;
    }

    /**
     * This is a function I made so i can look at the board in a easy fashion for testing
     */
    public void displayBoard(){
        for (int i= 0; i <boardSize;i++){
            for (int j= 0; j <boardSize;j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * this function is used to display a solved board
     */
    public void displaySolvedBoard(){
        if(solved) {
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    System.out.print(solvedBoard[i][j]);
                }
                System.out.println("");
            }
        }
    }
    /**
     * This sets the state of our sudoku board to solved
     * @param solvedBoard this is the board that is a solution to the original board
     */
    public void setSolvedBoard(String[][] solvedBoard) {
        this.solved = true;
        this.possibleToSolve = true;
        this.solvedBoard = solvedBoard;

    }

    /**
     *
     * @return list of the board values that can be used
     */
    public HashMap<String, String> getPossibleBoardValues() {
        return possibleBoardValues;
    }

    /**
     * This function gives the user a string of where the boards state is at.
     * We will return different things based on whether or not the board can be solved.
     * @return a string representing the status of the board.
     */
    public String solvedBoardExport(){
        String originalBoard="";

        for(int i = 0; i <boardSize;i++) {
            for (int j = 0; j < boardSize; j++) {
                originalBoard = originalBoard  + board[i][j]+ " " ;
            }
            originalBoard = originalBoard  +  "\n";
        }
        if(possibleToSolve) {
            if(solved){
                String solvedBoardFormatted="";

                for(int i = 0; i <boardSize;i++) {
                    for (int j = 0; j < boardSize; j++) {
                        solvedBoardFormatted= solvedBoardFormatted+ solvedBoard[i][j]+ " " ;
                    }
                    solvedBoardFormatted= solvedBoardFormatted+ "\n" ;
                }
                String listOfStrategies ="";
                for(String strategy: strategiesUsed.keySet()){
                    listOfStrategies = listOfStrategies + strategy + " TIMES USED: "+strategiesUsed.get(strategy)+"\n";
                }
                return (originalBoard+"SOLVED: "+solvedBoardFormatted+"TIME ELAPSED: "+this.timeElasped+" MILLISECONDS; STRATEGIES USED: "+
                        listOfStrategies);

            }
            else{
                return originalBoard+"NOT SOLVED YET";

            }
        }
        else{

            return originalBoard+"UNSOLVABLE";
        }
        }

}
