import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SudokuLoaderTest {

    @Test
    public void load() {
        File inputFolder = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\test");
        File[] listOfInputFiles = inputFolder.listFiles();
        ArrayList<SudokuPuzzle> SudokuPuzzles = new ArrayList<SudokuPuzzle>();
        SudokuLoader myLoader = new SudokuLoader(listOfInputFiles);
        SudokuPuzzles = myLoader.load();
        assertEquals(SudokuPuzzles.get(0).getFileName().getName(),"Puzzle-4x4-0001.txt");
    }

    @Test
    public void export() throws IOException {
        File outputFolder = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\testOutput");
        File inputFolder = new File("C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\test");
        File[] listOfInputFiles = inputFolder.listFiles();
        ArrayList<SudokuPuzzle> SudokuPuzzles = new ArrayList<SudokuPuzzle>();
        SudokuLoader myLoader = new SudokuLoader(listOfInputFiles);
        SudokuPuzzles = myLoader.load();
        myLoader.export(SudokuPuzzles,outputFolder);
        File myFile = new File(outputFolder.getPath()+"\\Puzzle-4x4-0001.txt");
        Scanner sc = new Scanner(myFile);

        assertEquals("2 - 3 1 1 3 - 4 3 1 4 - - 2 1 3 NOT SOLVED YET",sc.nextLine());
    }
}