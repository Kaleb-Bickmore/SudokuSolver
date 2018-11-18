public interface SudokuSolvingStrategy {
    public int checkOnPuzzle(SudokuPuzzle myPuzzle,String[][] solvedBoard,String[][] copySolvedBoard,int i);
}
