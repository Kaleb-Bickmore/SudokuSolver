import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
        /**
         * @param args list of arguments put into our main class
         */
        public static void main(String[] args) {
            //args = new String[3];
            //args[0] ="-h";
            //args[0] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input\\Puzzle-16x16-0301.txt";
            //args[1] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\myOutput\\Puzzle-16x16-0301.txt";
            if(args.length<=0){
                System.out.println("Invalid command line arguments, try typing \"-h\" for the list of arguments.");
                return;
            }
            if (args[0].equals("-h")) {
                System.out.println("List of Commands: ");
                System.out.println("1.) <input file name>\n" +
                        " reads puzzle from the specified input file and writes the output\n" +
                        "to the console");
                System.out.println("2.) <input file name> <output file name>\n" +
                        "reads puzzle from the specified input file and writes the output\n" +
                        "the specify output file ");
                return;

            } else if (args.length == 1) {
                File inputFile = new File(args[0]);
                File[] listOfInputFiles = new File[1];
                listOfInputFiles[0] = inputFile;
                ArrayList<SudokuPuzzle> SudokuPuzzles = new ArrayList<SudokuPuzzle>();
                SudokuLoader myLoader = new SudokuLoader(listOfInputFiles);
                SudokuPuzzles = myLoader.load();
                SudokuSolver mySolver = new SudokuSolver(SudokuPuzzles);
                ArrayList<SudokuPuzzle> SolvedPuzzles = mySolver.solve();
                myLoader.exportConsole(SolvedPuzzles);


            } else if (args.length == 2) {
                File inputFile = new File(args[0]);
                File outputFile = new File(args[1]);
                File[] listOfInputFiles = new File[1];
                listOfInputFiles[0] = inputFile;
                ArrayList<SudokuPuzzle> SudokuPuzzles = new ArrayList<SudokuPuzzle>();
                SudokuLoader myLoader = new SudokuLoader(listOfInputFiles);
                SudokuPuzzles = myLoader.load();
                SudokuSolver mySolver = new SudokuSolver(SudokuPuzzles);
                ArrayList<SudokuPuzzle> SolvedPuzzles = mySolver.solve();
                try {
                    myLoader.exportFile(SolvedPuzzles, outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Invalid command line arguments, try typing \"-h\" for the list of arguments.");
            }


//            }

        }
        public void loadDirectory(String [] args) {
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            File[] listOfInputFiles = inputFile.listFiles();
            ArrayList<SudokuPuzzle> SudokuPuzzles = new ArrayList<SudokuPuzzle>();
            SudokuLoader myLoader = new SudokuLoader(listOfInputFiles);
            SudokuPuzzles = myLoader.load();
            SudokuSolver mySolver = new SudokuSolver(SudokuPuzzles);
            ArrayList<SudokuPuzzle> SolvedPuzzles = mySolver.solve();
            try {
                myLoader.export(SolvedPuzzles, outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

