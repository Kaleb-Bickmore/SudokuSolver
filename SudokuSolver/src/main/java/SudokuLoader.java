import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SudokuLoader {
    private File [] listOfFiles;
    public SudokuLoader(File[] listOfFiles){
        this.listOfFiles = listOfFiles;
    }
    public ArrayList<SudokuPuzzle> load() {
        ArrayList<SudokuPuzzle> allSudokuPuzzles = new ArrayList<SudokuPuzzle>();

        for(File myFile : listOfFiles) {
            HashMap<String, String> possibleSudokuValues = new HashMap<String,String>();

            try {
                Scanner sc = new Scanner(myFile);
                int boardSize = Integer.parseInt(sc.next());
                for (int l = 0; l < boardSize; l++) {
                    String boardValue = sc.next();
                    possibleSudokuValues.put(boardValue, boardValue);
                }
                String[][] myBoard = new String[boardSize][boardSize];
                for (int i = 0; i < boardSize; i++) {
                    String[] boardRow = new String[boardSize];
                    for (int j = 0; j < boardSize; j++) {
                        boardRow[j] = sc.next();
                    }
                    myBoard[i] = boardRow;
                }
                allSudokuPuzzles.add(new SudokuPuzzle(boardSize, myBoard, possibleSudokuValues,myFile));
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            }
        }
        return allSudokuPuzzles;
    }
    void export(ArrayList<SudokuPuzzle> solvedSudokuPuzzles,File outputFolder) throws IOException {
        for(SudokuPuzzle myPuzzle: solvedSudokuPuzzles){
            File exportFile = new File(outputFolder.getPath()+"\\"+myPuzzle.getFileName().getName());
            FileWriter fw = new FileWriter(exportFile.getPath(),false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(myPuzzle.solvedBoardExport());
            pw.close();
        }

    }

    public void exportConsole(ArrayList<SudokuPuzzle> solvedPuzzles) {
        for (SudokuPuzzle sudokuPuzzle : solvedPuzzles) {
            System.out.println(sudokuPuzzle.solvedBoardExport());
        }
    }

    public void exportFile(ArrayList<SudokuPuzzle> solvedPuzzles, File outputFile) throws IOException {
        SudokuPuzzle myPuzzle = solvedPuzzles.get(0);
        FileWriter fw = new FileWriter(outputFile.getPath(),false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(myPuzzle.solvedBoardExport());
        bw.close();
    }
}
