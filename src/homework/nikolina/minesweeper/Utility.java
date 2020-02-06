package homework.nikolina.minesweeper;

import java.util.Arrays;

public class Utility {

    private static final String MINE = "X";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        runTests();
    }

    /**
     * Function passes through all values in 2 dimensional array of Strings. If the value contains "X" it skips it.
     * Otherwise, for each empty value "" it replaces it with a number indicating how many "X"s are around this field
     * (min is 0, max is 8, obviously).
     *
     * @param minefield is a 2 dimensional array of Strings. Initially, it contains only values "X"- depicting a mine
     *                  and ""- depicting a non-mine field.
     */
    private static void populateNonMineFields(String[][] minefield) {
        for (int row = 0; row < minefield.length; row++) {
            for (int column = 0; column < minefield[0].length; column++) {
                // YOUR CODE GOES HERE
            }
        }
    }

    private static void runTests() {
        /*
        X-
        --
         */
        String[][] test1 = {{MINE, EMPTY}, {EMPTY, EMPTY}};
        String[][] expected1 = {{MINE, "1"}, {"1", "1"}};
        populateNonMineFields(test1);
        System.out.println("Test 1: " + (equal(test1, expected1) ? "SUCCESS" : "FAIL"));

        /*
        XX-
        -X-
        ---
         */
        String[][] test2 = {{MINE, MINE, EMPTY}, {EMPTY, MINE, EMPTY}, {EMPTY, EMPTY, EMPTY}};
        String[][] expected2 = {{MINE, MINE, "2"}, {"3", MINE, "2"}, {"1", "1", "1"}};
        populateNonMineFields(test2);
        System.out.println("Test 2: " + (equal(test2, expected2) ? "SUCCESS" : "FAIL"));

        /*
        XXX
        X-X
        XXX
        ---
         */
        String[][] test3 = {{MINE, MINE, MINE}, {MINE, EMPTY, MINE}, {MINE, MINE, MINE}, {EMPTY, EMPTY, EMPTY}};
        String[][] expected3 = {{MINE, MINE, MINE}, {MINE, "8", MINE}, {MINE, MINE, MINE}, {"2", "3", "2"}};
        populateNonMineFields(test3);
        System.out.println("Test 3: " + (equal(test3, expected3) ? "SUCCESS" : "FAIL"));

        /*
        ---X-
        X-X--
        XX---
        -----
         */
        String[][] test4 = {{EMPTY, EMPTY, EMPTY, MINE, EMPTY}, {MINE, EMPTY, MINE, EMPTY, EMPTY}, {MINE, MINE, EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}};
        String[][] expected4 = {{"1", "2", "2", MINE, "1"}, {MINE, "4", MINE, "2", "1"}, {MINE, MINE, "2", "1", "0"}, {"2", "2", "1", "0", "0"}};
        populateNonMineFields(test4);
        System.out.println("Test 4: " + (equal(test4, expected4) ? "SUCCESS" : "FAIL"));
    }

    private static boolean equal(String[][] m1, String[][] m2) {
        if (null == m1 || null == m2) {
            return false;
        }

        if (m1.length != m2.length) {
            return false;
        }

        for (int entry = 0; entry < m1.length; entry++) {
            if (!Arrays.equals(m1[entry], m2[entry])) {
                return false;
            }
        }

        return true;
    }
}
