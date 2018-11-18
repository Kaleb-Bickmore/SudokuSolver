public class SudokuNotInvalid implements SudokuSolvingStrategy{
    @Override
    public int checkOnPuzzle(SudokuPuzzle myPuzzle, String[][] solvedBoard,String [] []copySolvedBoard,int i) {
        if (SudokuChecker.checkCellsFilled(solvedBoard)) {
            System.out.println("Solved...");
            myPuzzle.setSolvedBoard(solvedBoard);
        }
        if (compareBoards(solvedBoard, copySolvedBoard)) {
                i = ((i) % 3) + 1;
        }
        return i;

    }
        public boolean compareBoards(String[][] firstBoard,String [] [] secondBoard){
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
