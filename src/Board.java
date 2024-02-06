/**
 * CPSC 233 W24 Assignment 1 Starter to use to make Board.java
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 */
public class Board {

    /**
     * No piece in board (empty)
     */
    public static final int EMP = Game.EMP;
    /**
     * Connect-L Red Piece
     */
    public static final int RED = Game.RED;
    /**
     * Connect-L Blue Piece
     */
    public static final int BLU = Game.BLU;

    //Students should enter their functions below here

    public static int[][] createBoard(int rows, int columns) {
    //emp = 0???
        int[][] board;
        board = new int[rows][columns];
        for (int x = 0; x < board.length - 1; x++) {
            for (int j = 0; j < columns; j++) {
                board[x][j] = 0;
            }
        }
        return (board);
    }
    public static int rowCount(int[][]board) {
        int i = board.length;
        return i;
    }
    public static int columnCount(int[][] board) {
        int l = 0;
        int[] j = board[0];
        for (int x : j) {
            l = l + 1;
        }
        return l;
    }
    public static Boolean valid(int[][] board, int row, int column) {
        if (row < 0) {
            return (false);
        } else if (column < 0) {
            return (false);
        } else if (row > board.length - 1) {
            return (false);
        } else if (column > board[0].length-1) {
            return (false);
        } else {
            return (true);
        }
    }
    //boolean or Boolean
    public static boolean canPlay(int[][] board, int column) {
            for (int j = 0; j < board.length-1; j++) {
                if (board[j][column] == 0) {
                    return (true);
                }
                else{
                    return (false);
                }
            }
            return true;
    }

    public static int play(int[][] board, int column, int piece) {
        int [] arr = new int[8];
        for (int j = board.length - 1; j < board.length - 1 && j >= 0; j--) {
            if (board[j][column] == 0) {
                board[j][column] = piece;
                return j;
            }
            else return -1;
        }
        //need this???
        return -5;
    }
    public static int removeLastPlay(int[][] board, int column) {
        for (int j = 0; j< board.length-1; j++){
            if (board[j][column] == 1 || board[j][column] == 2){
                board[j][column] = 0;
                return j;
            }
            else return -1;
        }
        return -5;
    }
    private static boolean full(int[][] board) {
        int l = 0;
        for (int i = 0; i<=board.length-1; i++){
            for (int j = 0; j <board[0].length-1;j++){
                if (board[i][j]==2 || board[i][j]==1){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
    private static boolean winInRow(int[][] board, int row, int piece, int length) {
        int k = 0;
        int [] arr = new int[board[0].length];
        for(int i = 0; i<board[0].length; i++) {
            arr[i] = board[row][i];
            if (board[row][i] == piece){
                k = k+1;
            }
        }
        int m =0;
        if (k>=length) {
            while (m < board.length) {
                if (board[row][m] == piece) {
                    if (board[row + 1][m] == piece) {
                        m = board.length + 1;
                        return true;
                    }
                    else if(board[row-1][m] == piece){
                        m = board.length + 2;
                        return true;
                    }
                }
                m = m + 1;
            }
        }
        int l = board.length;
        if (k>=length){
            while (m <= board.length){
                if (board[row][m] == piece) {
                    if (board[row + 1][m] == piece) {
                        m = board.length + 2;
                        return true;
                    }
                    // make sure to account for -1 and over the column of the game board
                    else if(board[row-1][m] == piece){
                        m = board.length + 2;
                        return true;
                    }
                }
                m = m - 1;
            }

        }

        else{
                return false;
            }
            m = m+1;
            return false;
    }
    private static boolean winInColumn(int[][] board, int col, int piece, int length) {
        return true;
    }
    public static int[] hint(int[][] board, int human, int length) {
        return(null);
    }




    private static boolean winInDiagonalBackslash(int[][] board, int piece, int length) {
        return true;
    }
    private static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {
        return true;
    }


    //Students should enter their functions above here
    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any row
     * @return True if there is length in any row, False otherwise
     */
    private static boolean winInAnyRow(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            if (winInRow(board, row, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any column of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any column
     * @return True if there is length in any column, False otherwise
     */
    private static boolean winInAnyColumn(int[][] board, int piece, int length) {
        for (int col = 0; col < board[0].length; col++) {
            if (winInColumn(board, col, piece, length)) {
                return true;
            }
        }
        return false;
    }



    /**
     * Is there a win in given board in any diagonal of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any diagonal
     * @return True if there is length in any diagonal /\, False otherwise
     */
    private static boolean winInAnyDiagonal(int[][] board, int piece, int length) {
        return winInDiagonalBackslash(board, piece, length) || winInDiagonalForwardSlash(board, piece, length);
    }

    /**
     * Has the given piece won the board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to check for a win
     * @return True if piece has won
     */
    public static boolean won(int[][] board, int piece, int length) {
        return winInAnyRow(board, piece, length) || winInAnyColumn(board, piece, length) || winInAnyDiagonal(board, piece, length);
    }

    /**
     * This function determines if the game is complete due to a win or tie by either player
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @return True if game is complete, False otherwise
     */
    public static boolean isGameOver(int[][] board, int length) {
        return full(board) || won(board, RED, length) || won(board, BLU, length);
    }
}
