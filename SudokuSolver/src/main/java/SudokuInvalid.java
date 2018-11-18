import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class SudokuInvalid implements SudokuSolvingStrategy {
    @Override
    public int checkOnPuzzle(SudokuPuzzle myPuzzle, String[][] solvedBoard,String[][] copySolvedBoard,int i) {
        String[][] copyOldState = myPuzzle.getPreviousState();
        for(int k =0; k <solvedBoard.length;k++){
            for(int l=0;l<solvedBoard.length;l++){
                solvedBoard[k][l] = copyOldState[k][l];
            }
        }
        if(!SudokuChecker.checkNotEmpty(solvedBoard)){
            System.out.println("cannot be solved...");
            myPuzzle.setPossibleToSolve(Boolean.FALSE);
            return i;
        }
        else{
            return 1;
        }

    }
}
