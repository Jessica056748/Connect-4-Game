import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CPSC 233 W24 Assignment 1 BoardTest Starter File
 * Holds a helper deep copy and example tests of deep copy
 * @author Jessica Truong, Jonathan Hudson
 * @email jessica.truong1@ucalgary.ca, jwhudson@ucalgary.ca
 * February 2 2024, Tutorial 15
 * @version 1.0
 */
public class BoardTest {
    /**
     * Used to make a copy of board before functions run, so that verify a function was non-destructive on board is easy
     * @param board The board to make deep copy of
     * @return A deep copy of given board
     */
    public int[][] deepCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }

    @Test
    //uneven sizing of board (vertically)
    public void testcreateBoardRow() {
        int[][] expected = new int[5][4];
        int[][] actual = Board.createBoard(5,4);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testcreateBoardMaximum() {
        int[][] expected = new int[8][8];
        int[][] actual = Board.createBoard(8,8);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testcreateBoardMinimum() {
        int[][] expected = new int[4][4];
        int[][] actual = Board.createBoard(4,4);
        assertArrayEquals(expected,actual);
    }
    @Test
    //uneven sizing of board (horizontally)
    public void testcreateBoardColumn() {
        int[][] expected = new int[3][8];
        int[][] actual = Board.createBoard(3,8);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void createBoardsquare() {
        int[][] expected = new int[6][6];
        int[][] actual = Board.createBoard(6,6);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testrowCount() {
        int [][] arr = new int[6][6];
        int expected = 6;
        int actual = Board.rowCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    public void testrowCountMaximum() {
        int [][] arr = new int[8][6];
        int expected = 8;
        int actual = Board.rowCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    public void testrowCountMinimum() {
        int [][] arr = new int[4][6];
        int expected = 4;
        int actual = Board.rowCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    public void testrowCount2() {
        int [][] arr = new int[7][8];
        int expected = 7;
        int actual = Board.rowCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    public void testrowCount3() {
        int [][] arr = new int[5][6];
        int expected = 5;
        int actual = Board.rowCount(arr);
        assertEquals(expected, actual);
    }

    @Test
    public void testcolumnCount() {
        int [][] arr = new int[4][6];
        int expected = 6;
        int actual = Board.columnCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    public void testcolumnCountMaximum() {
        int [][] arr = new int[3][8];
        int expected = 8;
        int actual = Board.columnCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    public void testcolumnCountMinimum() {
        int [][] arr = new int[4][4];
        int expected = 4;
        int actual = Board.columnCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    //uneven sizing of board horizontal
    public void testcolumnCount2() {
        int [][] arr = new int[6][7];
        int expected = 7;
        int actual = Board.columnCount(arr);
        assertEquals(expected, actual);
    }
    @Test
    //uneven sizing of board vertical
    public void testcolumnCount3() {
        int [][] arr = new int[6][5];
        int expected = 5;
        int actual = Board.columnCount(arr);
        assertEquals(expected, actual);
    }

    @Test
    //testing a square board
    public void valid1() {
        int [][] arr = new int[6][6];
        boolean expected = true;
        boolean actual = Board.valid(arr,0,0);
        assertEquals(expected, actual);
    }
    @Test
    //testing maximum
    public void valid2OutOfBoundRow() {
        int [][] arr = new int[5][8];
        boolean expected = false;
        boolean actual = Board.valid(arr,0,9);
        assertEquals(expected, actual);
    }
    @Test
    public void validminimumRow() {
        int [][] arr = new int[3][3];
        boolean expected = false;
        boolean actual = Board.valid(arr,4,4);
        assertEquals(expected, actual);
    }
    @Test
    public void valid4outOfBoundColumn() {
        int [][] arr = new int[7][3];
        boolean expected = false;
        boolean actual = Board.valid(arr,9,0);
        assertEquals(expected, actual);
    }
    @Test
    public void valid2InBound() {
        int [][] arr = new int[5][7];
        boolean expected = true;
        boolean actual = Board.valid(arr,4,6);
        assertEquals(expected, actual);
    }
    @Test
    public void canPlay1() {
        int [][]arr = {{1,2,1,1},{2,1,0,1},{2,0,2,1},{1,2,0,2}};
        boolean expected = true;
        boolean actual = Board.canPlay(arr,2);
        assertEquals(expected, actual);
    }
    @Test
    public void canPlay2Invalid() {
        int [][]arr = {{2,1,0,1},{2,2,0,1},{2,0,1,1},{1,2,2,2}};
        boolean expected = false;
        boolean actual = Board.canPlay(arr,3);
        assertEquals(expected, actual);
    }
    @Test
    public void canPlayLastColumn() {
        int [][]arr = {{2,1,0,0},
                        {1,2,2,1},
                        {2,1,2,1},
                        {1,2,1,2},
                        {2,2,1,2},
                        {1,1,2,1}};
        boolean expected = true;
        boolean actual = Board.canPlay(arr,3);
        assertEquals(expected, actual);
    }
    @Test
    public void canPlayFirstColumn() {
        int [][]arr = {{0,0,0,0,0,0},{0,0,0,0,0,2,1},{0,1,2,1,2,0}};
        boolean expected = true;
        boolean actual = Board.canPlay(arr,0);
        assertEquals(expected, actual);
    }
    @Test
    public void canPlay5Full() {
        int [][]arr = {{1,1,1,1,1},{2,2,2,2,2},{1,1,2,1,2}};
        boolean expected = false;
        boolean actual = Board.canPlay(arr,4);
        assertEquals(expected, actual);
    }
    @Test
    public void playFirstCorner(){
        int [][]arr = {{0,0,0,0},
                        {2,1,2,0},
                        {1,1,2,1},
                        {1,2,1,2}};
        int piece = 2;
        int expected = 0;
        int actual = Board.play(arr,0,piece);
        assertEquals(expected,actual);
    }
    @Test
    public void playFull(){
        int [][]arr = {{1,2,0,0},
                        {2,1,2,0},
                        {2,2,2,1},
                        {1,2,1,2},
                        {1,2,2,1},
                        {1,1,1,2}};
        int piece = 2;
        int expected = -1;
        int actual = Board.play(arr,1,piece);
        assertEquals(expected,actual);
    }
    @Test
    public void playLastColumn(){
        int [][]arr = {{1,2,0,0,0},
                        {2,1,2,0,0},
                        {2,2,2,1,0},
                        {1,2,1,2,0},
                        {1,2,2,1,0},
                        {1,1,1,2,0}};
        int piece = 1;
        int expected = 5;
        int actual = Board.play(arr,4,piece);
        assertEquals(expected,actual);
    }
    @Test
    public void playFirstRow(){
        int [][]arr = {{1,2,0,0,0,0},
                        {2,1,2,1,2,1},
                        {2,2,2,1,1,2},
                        {1,2,1,2,1,2}};
        int piece = 1;
        int expected = 0 ;
        int actual = Board.play(arr,3,piece);
        assertEquals(expected,actual);
    }
    @Test
    public void play5(){
        int [][]arr = {{1,2,0,0,0,0,0},
                        {2,1,2,0,2,1,2},
                        {2,2,2,0,1,2,1},
                        {1,2,1,0,1,2,2},
                        {1,2,1,2,1,2,1},
                        {1,2,1,2,1,2,1}};
        int piece = 1;
        int expected = 3 ;
        int actual = Board.play(arr,3,piece);
        assertEquals(expected,actual);
    }
    @Test
    public void removeLastPlayCornerLeft(){
        int [][] arr = {{1,2,0,0},
                        {2,1,2,0},
                        {2,2,2,0},
                        {2,2,2,1}};
        int expected = 3;
        int actual = Board.removeLastPlay(arr,3);
        assertEquals(expected,actual);
    }
    @Test
    public void removeLastPlayFirstSpot(){
        int [][] arr = {{1,0,2,0,1,0},
                        {2,1,2,0,2,0},
                        {2,2,2,1,1,2},
                        {2,2,2,1,1,1}};
        int expected = 1;
        int actual = Board.removeLastPlay(arr,1);
        assertEquals(expected,actual);

    }
    @Test
    public void removeLastPlayNoPlays(){
        int [][] arr = {{1,2,0,0},
                        {2,1,2,0},
                        {2,1,2,0},
                        {1,1,2,0},
                        {1,2,1,0},
                        {1,1,2,0},
                        {1,2,2,0},
                        {1,2,1,0}};
        int expected = -1;
        int actual = Board.removeLastPlay(arr,3);
        assertEquals(expected,actual);

    }
    @Test
    public void removeLastPlayFirstRow(){
        int [][] arr = {{1,2,0,0,2},
                {2,1,2,0,1},
                {2,1,2,0,2},
                {1,1,2,2,1},
                {1,2,1,1,2},
                {1,1,2,1,1}};
        int expected = 0;
        int actual = Board.removeLastPlay(arr,1);
        assertEquals(expected,actual);

    }
    @Test
    public void removeLastPlay5(){
        int [][] arr = {{1,0,0,0},
                        {2,0,2,0},
                        {2,0,2,0},
                        {1,2,2,0},
                        {1,2,1,1}};
        int expected = 3;
        int actual = Board.removeLastPlay(arr,1);
        assertEquals(expected,actual);

    }
    @Test
    public void FullNotfull(){
        int [][] arr = {{1,2,0,0,2},{2,1,2,0,1},{2,1,2,0,2},{1,1,2,2,1},{1,2,1,1,2},{1,1,2,1,1}};
        boolean expected = false;
        boolean actual = Board.full(arr);
        assertEquals(expected,actual);

    }
    @Test
    public void Full2(){
        int [][] arr = {{1,1,2,2},{1,1,2,2},{2,2,2,1},{1,1,1,1}};
        boolean expected = true;
        boolean actual = Board.full(arr);
        assertEquals(expected,actual);
    }
    @Test
    public void FullOneSpotLeft(){
        int [][] arr = {{1,1,2,0,2,1,2},{1,1,2,2,1,2,1},{2,2,2,1,1,1,2},{1,1,1,1,2,2,1}};
        boolean expected = false;
        boolean actual = Board.full(arr);
        assertEquals(expected,actual);

    }
    @Test
    public void Full4(){
        int [][] arr = {{1,1,2,2,2,1,2},{1,1,2,2,1,2,1},{2,2,2,1,1,1,2},{1,1,1,1,2,2,1},{1,1,1,2,2,1,1},{1,2,2,1,1,1,2}};
        boolean expected = true;
        boolean actual = Board.full(arr);
        assertEquals(expected,actual);
    }
    @Test
    public void FullNoPlays(){
        int [][] arr = {{0,0,0,0}, {0,0,0,0},{0,0,0,0},{0,0,0,0}};
        boolean expected = false;
        boolean actual = Board.full(arr);
        assertEquals(expected,actual);
    }

    @Test
    //testing edge
    public void winInRow1(){
        int [][] arr = {{0,0,0,0},
                        {0,1,0,0},
                        {2,1,1,1},
                        {2,2,2,0}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,3,2,3);
        assertEquals(expected,actual);
    }
    @Test
    public void winInRowLengthGreaterthaninputted(){
        int [][] arr = {{1,1,1,1,1},
                        {1,2,2,1,1},
                        {2,2,2,1,1},
                        {2,2,2,2,1}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,0,1,3);
        assertEquals(expected,actual);
    }
    //something wrong with the right side
    @Test
    public void winInRowLastRow(){
        int [][] arr = {{0,0,0,0},
                        {0,1,2,2},
                        {2,2,2,1},
                        {1,1,1,1}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,3,1,3);
        assertEquals(expected, actual);
    }
    @Test
    public void winInRowInTheMiddle(){
        int [][] arr = {{0,0,0,0,0},
                        {1,1,0,2,1},
                        {0,1,1,1,2},
                        {2,2,2,2,2}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,2,1,3);
        assertEquals(expected,actual);
    }
    @Test
    public void winInRowFirstColumns(){
        int [][] arr = {{0,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1},
                        {1,1,1,2,2}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,2,1,5);
        assertEquals(expected,actual);
    }
    @Test
    public void winInRowLeftCorner(){
        int [][] arr = {{0,0,1,1,1},
                        {0,1,1,0,1},
                        {0,2,2,2,1},
                        {0,2,1,1,0}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,0,1,3);
        assertEquals(expected,actual);
    }
    @Test
    public void winInRow7(){
        int [][] arr = {{0,0,1,0,0,0,0,0},
                        {1,2,2,1,1,0,0,0},
                        {2,1,1,1,1,1,1,1},
                        {1,2,2,2,2,1,2,1}};
        boolean expected = true;
        boolean actual = Board.winInRow(arr,2,1,4);
        assertEquals(expected,actual);
    }

    @Test
    public void winInColumnFirstColumn(){
        int [][] arr = {{0,0,1,0,0},
                        {1,2,2,1,0},
                        {1,1,1,1,0},
                        {1,1,1,2,2}};
        boolean expected = true;
        boolean actual = Board.winInColumn(arr,0,1,3);
        assertEquals(expected,actual);
    }
    @Test
    public void winInColumnLastColumn(){
        int [][] arr = {{0,0,0,0,1},
                        {1,2,2,1,1},
                        {2,1,2,0,1},
                        {1,1,1,1,1}};
        boolean expected = true;
        boolean actual = Board.winInColumn(arr,4,1,4);
        assertEquals(expected,actual);
    }
    @Test
    //different orientation of L
    public void winInColumn3(){
        int [][] arr = {{0,2,2,0,1},
                        {0,2,0,0,2},
                        {1,2,1,1,1},
                        {1,2,0,2,1},
                        {1,1,1,2,2},
                        {1,1,2,2,1},
                        {2,2,1,2,1}};
        boolean expected = true;
        boolean actual = Board.winInColumn(arr,1,2,3);
        assertEquals(expected,actual);
    }

    @Test
    //different orientation of L
    public void winInColumn4(){
        int [][] arr = {{0,0,0,1,1},
                        {0,1,0,0,1},
                        {2,1,2,2,1},
                        {2,1,2,1,1}};
        boolean expected = true;
        boolean actual = Board.winInColumn(arr,4,1,4);
        assertEquals(expected,actual);
    }

    @Test
    public void winInColumnMiddle(){
        int [][] arr = {{0,1,0,2,2},
                        {2,1,1,1,2},
                        {1,1,1,2,2},
                        {2,1,1,2,1},
                        {2,1,1,1,1},
                        {2,1,1,1,1}};
        boolean expected = true;
        boolean actual = Board.winInColumn(arr,2,1,5);
        assertEquals(expected,actual);
    }

    @Test
    // Testing when L has the shorter side to the upper left
    public void winInBackslash1(){
        int [][] arr = {{0,2,2,0,0},
                        {0,1,2,0,2},
                        {1,0,1,2,1},
                        {2,1,2,1,1},
                        {2,1,2,1,1},
                        {2,1,2,1,1}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalBackslash(arr,1,4);
        assertEquals(expected,actual);
    }
    @Test
    // Testing when L has the shorter side to the upper right
    public void winInBackslash2(){
        int [][] arr = {{0,1,0,0,0},
                        {1,2,2,0,2},
                        {1,1,2,2,2},
                        {2,1,1,0,1}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalBackslash(arr,1,3);
        assertEquals(expected,actual);
    }
    @Test
    // Testing when L has the shorter side to the lower left in the middle
    public void winInBackslash3(){
        int [][] arr = {{0,2,0,0,2,0,0},
                        {1,2,2,1,0,0,2},
                        {2,1,1,2,1,0,1},
                        {2,1,2,2,1,0,1}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalBackslash(arr,2,3);
        assertEquals(expected,actual);
    }
    @Test
    // Testing when L has the shorter side to the lower right
    public void winInBackslash4(){
        int [][] arr = {{0,2,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,1,2,1,2,1},
                        {2,2,1,2,1,1},
                        {2,1,2,1,1,0},
                        {2,2,1,2,1,0},
                        {2,1,1,1,1,0}};

        boolean expected = true;
        boolean actual = Board.winInDiagonalBackslash(arr,1,4);
        assertEquals(expected,actual);
    }
    @Test
    //Testing for L touching the sides
    public void winInBackslash5(){
        int [][] arr = {{2,0,0,2,0,0,0},
                        {0,1,2,1,2,0,2},
                        {1,0,1,2,2,2,2},
                        {2,0,2,1,0,0,2},
                        {0,0,0,0,2,0,1}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalBackslash(arr,1,3);
        assertEquals(expected,actual);
    }
    @Test
    //different versions of L rotations
    public void wininforwardslash1(){
        int [][] arr = {
                        {0,0,1,2,0},
                        {0,1,2,1,0},
                        {1,2,1,1,0},
                        {1,1,2,0,0}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalForwardSlash(arr,2,3);
        assertEquals(expected,actual);
    }
    @Test
    //different versions of L rotations
    public void wininforwardslash2(){
        int [][] arr = {{0,0,0,0},
                        {0,0,1,0},
                        {2,1,0,1},
                        {1,0,2,2}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalForwardSlash(arr,1,3);
        assertEquals(expected,actual);
    }
    @Test
    //different versions of L rotations
    public void wininforwardslash3(){
        int [][] arr = {{0,0,1,0,2,0},
                        {0,2,1,2,0,2},
                        {2,2,2,1,0,0},
                        {1,2,1,1,0,1},
                        {1,2,1,2,0,1},
                        {1,2,1,2,0,1}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalForwardSlash(arr,2,4);
        assertEquals(expected,actual);
    }
    @Test
    //different versions of L rotations
    public void wininforwardslash4(){
        int [][] arr = {{0,0,2,0,0,0,0},
                        {0,0,1,2,0,0,0},
                        {0,2,2,1,0,0,0},
                        {1,2,1,0,0,1,2},
                        {1,1,1,0,0,1,1}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalForwardSlash(arr,1,3);
        assertEquals(expected,actual);
    }
    @Test
    //testing corners
    public void wininforwardslash5(){
        int [][] arr = {
                        {0,0,0,2,0,0,1},
                        {0,2,2,1,0,1,0},
                        {1,2,0,0,1,0,2},
                        {0,0,0,0,0,0,0}};
        boolean expected = true;
        boolean actual = Board.winInDiagonalForwardSlash(arr,1,3);
        assertEquals(expected,actual);
    }

    @Test
    //Next winning move
    public void hint1(){
        int [][] arr = {{0,0,0,0,0},
                        {0,0,0,0,2},
                        {0,1,0,0,0},
                        {2,1,2,1,2},
                        {2,1,2,1,2},
                        {2,2,2,1,2}};
        int [] expected = {2,0};
        int[] actual = Board.hint(arr,1,3);
        assertArrayEquals(expected,actual);
    }
    @Test
    //next winning row move
    public void hint2(){
        int [][] arr = {{0,0,0,0,0,0},
                        {0,0,2,2,2,0},
                        {1,1,1,1,1,0},
                        {2,1,2,1,2,0}};
        int [] expected = {0,2};
        int[] actual = Board.hint(arr,2,3);
        assertArrayEquals(expected,actual);
    }

    @Test
    //no winning move
    public void hint3(){
        int [][] arr = {{1,1,2,2,2,0},
                        {1,1,1,1,1,0},
                        {2,1,2,1,2,0}};
        int [] expected = {-1,-1};
        int[] actual = Board.hint(arr,2,3);
        assertArrayEquals(expected,actual);
    }
    @Test
    // Forwarddiagonal win
    public void hintfull4(){
        int [][] arr = {{2,1,0,0,2},
                        {1,2,2,1,1},
                        {1,2,1,2,1},
                        {2,1,1,1,1},
                        {1,2,2,1,1}};
        int [] expected = {0,2};
        int[] actual = Board.hint(arr,1,4);
        assertArrayEquals(expected,actual);
    }
    @Test
    //empty board
    public void hintempty5(){
        int [][] arr = {{0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0}};
        int [] expected = {-1,-1};
        int[] actual = Board.hint(arr,2,3);
        assertArrayEquals(expected,actual);
    }
    @Test
    // Forwardslash diagonal win
    public void hintfull6(){
        int [][] arr = {{0,0,2,0,2,0},
                        {1,2,2,2,1,0},
                        {1,2,2,2,2,0},
                        {2,1,1,2,2,0}};
        int [] expected = {0,0};
        int[] actual = Board.hint(arr,2,4);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void deepCopyTestNoChange() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestChangeEntryIn2D() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0][0] = 99;
        assertTrue(!Arrays.deepEquals(expected, actual));
    }


    @Test
    public void deepCopyTestSet1DRefToDiffButIdenticalArray() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0] = new int[]{0,1};
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestSet1DRefToDiffArray() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0] = new int[]{0,99};
        assertTrue(!Arrays.deepEquals(expected, actual));
    }

}

