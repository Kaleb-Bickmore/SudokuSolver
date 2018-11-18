import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void main() {
        Client myClient = new Client();
        String[] args = new String[1];
        args[0] ="-h";
        myClient.main(args);
        /**
         * You should see a help menu here
         */
        String[] args2 = new String[1];

        args2[0] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input\\Puzzle-9x9-0401.txt";
        myClient.main(args2);
        /**
         * This outputs the solution to one of the puzzles to the console
         */
        String[] args3 = new String[2];
        args3[0] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input\\Puzzle-9x9-0401.txt";
        args3[1] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\myOutput\\Puzzle-9x9-0401.txt";

        myClient.main(args3);
        /**
         * This outputs the solution to one of the puzzles to a file
         */
        String[] args4 = new String[5];
        args4[0] = "this";
        args4[1] = "is";
        args4[2] = "a";
        args4[3] = "bad";
        args4[4] = "command";
        myClient.main(args4);
        String[] args5 = new String[0];
        myClient.main(args5);
        /**
          * these are both invalid commands
          */
        /**
         * bad boards
         */
        String[] args6 = new String[2];
        args6[0] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input\\Puzzle-4x4-0901.txt";
        args6[1] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\myOutput\\Puzzle-4x4-0901.txt";

        myClient.main(args6);

        String[] args7 = new String[2];
        args7[0] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input\\Puzzle-4x4-0903.txt";
        args7[1] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\myOutput\\Puzzle-4x4-0903.txt";

        myClient.main(args7);
        String[] args8 = new String[2];
        args8[0] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\input";
        args8[1] = "C:\\Users\\Kaleb\\Documents\\ObjectODesign\\CS5700HW4\\CS5700HW4\\hw4b\\SamplePuzzles\\myOutput";

        myClient.loadDirectory(args8);
    }
}