import java.util.Arrays;
/**
 * CPSC 233 W24 Assignment 1 Starter to use to make Board.java
 * @author Jonathan Hudson
 * @ email jessica.truong1@ucalgary.ca , jwhudson@ucalgary.ca
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

    public static int[][]createBoard(int rows, int columns) {
    //emp = 0???
        int [][] board = new int[rows][columns];
        for (int x = 0; x < rows ; x++) {
            for (int j = 0; j < columns; j++) {
                board[x][j] = EMP;
            }
        }
        return (board);
    }
    public static int rowCount(int[][]board) {
        int ROW = board.length;
        return ROW;
    }

    public static int columnCount(int[][] board) {
        int COLUMN = board[0].length;
        return COLUMN;
    }
    public static boolean valid(int[][] board, int row, int column) {
        if (row < 0) {
            return (false);
        } else if (column < 0) {
            return (false);
        } else if (row > board.length) {
            return (false);
        } else if (column > board[0].length) {
            return (false);
        } else {
            return (true);
        }
    }
    //boolean or Boolean
    public static boolean canPlay(int[][] board, int column) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][column] == EMP) {
                    return (true);
                }
            }
           return false;
    }

    public static int play(int[][] board, int column, int piece) {
        for (int j = board.length - 1; j >= 0; j--) {
            if (board[j][column] == EMP) {
                board[j][column] = piece;
                return j;
            }
        }
        return -1;
    }
    public static int removeLastPlay(int[][] board, int column) {
        for (int j = 0; j< board.length; j++){
            if (board[j][column] == 1 || board[j][column] == 2){
                board[j][column] = EMP;
                return j;
            }
        }
        return -1;
    }
    public static boolean full(int[][] board) {
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j <board[0].length;j++){
                if (board[i][j]==EMP){
                    return false;
                }

            }
        }
        return true;
    }
    public static boolean winInRow(int[][] board, int row, int piece, int length) {
        for (int j = 0; j < board[0].length; j++) {
                int I = 0;
                int NumberOfPieces = 1;
                if (board[row][j] == piece) {
                    if (row == board.length-1) {
                        if (board[row-1][j] == piece){
                            I++;
                        }
                    } else if (row == 0) {
                        if (board[row+1][j] == piece){
                            I++;
                        }
                    } else if (board[row+1][j] == piece) {
                        I++;
                    } else if (board[row-1][j] == piece) {
                        I++;
                    }
                    for (int k = 0; k < board[0].length - j - 1 ; k++) {
                        if (j+k == board[0].length -1){
                            if (NumberOfPieces >= length) {
                                if (row == board.length-1) {
                                    if (board[row - 1][j + k] == piece) {
                                            I++;
                                        }
                                    }
                                else if (row == 0) {
                                    if (board[row + 1][j + k] == piece) {
                                            I++;
                                        }
                                        }

                                else if (board[row + 1][j+k] == piece) {
                                    return true;
                                } else if (board[row - 1][j+k] == piece) {
                                    return true;
                                }  if (I > 0) {
                                    return true;
                                }
                                else {
                                    return false;
                                }
                            }
                            else {
                                return false;
                            }
                        }
                        else if (board[row][j+k+1] == piece) {
                            NumberOfPieces++;
                        }

                        else if (board[row][j + k+1] != piece) {
                            if (NumberOfPieces < length) {
                                return false;
                            }
                            else {

                                if (row == board.length-1) {
                                    if (board[row - 1][j + k] == piece) {
                                        I++;
                                    }
                                }
                                else if (row == 0) {
                                    if (board[row + 1][j + k] == piece) {
                                            I++;
                                    }
                                }
                                else if (board[row + 1][j + k] == piece) {
                                    return true;
                                } else if (board[row - 1 ][j + k] == piece) {
                                    return true;
                                }
                                if (I > 0){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        return false;
    }


    public static boolean winInColumn(int[][] board, int column, int piece, int length) {
        for (int j = 0; j < board.length; j++) {
            int I = 0;
            int NumberOfPieces = 1;
            if (board[j][column] == piece) {
                if (column == board[0].length - 1) {
                    if (board[j][column - 1] == piece) {
                        I++;
                    }
                }
                else if (column == 0) {
                    if (board[j][column + 1] == piece) {
                        I++;
                    }
                }
                else if (board[j][column + 1] == piece) {
                    I++;
                }
                else if (board[j][column - 1] == piece) {
                    I++;
                }
                for (int k = 0; k < board.length - j - 1; k++) {
                    if (j + k == board.length - 1) {
                        if (NumberOfPieces >= length) {
                            if (column == board[0].length - 1) {
                                if (board[j + k][column - 1] == piece) {
                                    return true;
                                }
                            }
                            else if (column == 0) {
                                if (board[j + k][column + 1] == piece) {
                                    return true;
                                }
                            }
                            else if (board[j + k][column + 1] == piece) {
                                return true;

                            } else if (board[j + k][column - 1] == piece) {
                                return true;
                            }
                            else if (I > 0) {
                                return true;
                            }
                            else {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                    }
                    else if (board[j + k + 1][column] == piece) {
                        NumberOfPieces++;
                    }
                    else if (board[j + k + 1][column] != piece) {
                        if (NumberOfPieces < length) {
                            return false;
                        }
                        else if (NumberOfPieces >= length){
                            if (column == board[0].length - 1) {
                                if (board[j + k][column - 1] == piece) {
                                    return true;
                                }
                            }
                            else if (column == 0) {
                                if (board[j + k][column + 1] == piece) {
                                    return true;
                                }
                            }
                            else if (board[j + k][column + 1] == piece) {
                                return true;
                            }
                            else if (board[j + k][column - 1] == piece) {
                                return true;
                            }
                            else if (I > 0) {
                                return true;
                            }
                            else return false;
                        }
                    }
                }
            }
        }
            return false;
    }
    public static boolean winInDiagonalBackslash(int[][] board, int piece, int length) {
        for (int i = 0; i < board.length; i++) {
            int PIECE = 1;
            int I = 0;
            for (int j = 0; j < board[0].length; j++) {
                //Checks for the first L shape
                if (board[i][j] == piece){
                    if (i == 0) {
                    }
                    else if (i == board.length - 1) {
                    }
                    else if (j == 0) {

                    }
                    else if (j == board[0].length-1) {

                    }
                    else if (board[i - 1][j + 1] == piece){
                        I++;
                    }
                    else if (board[i + 1][j - 1] == piece){
                        I++;
                    }
                    int[] arr = new int[2];
                    Arrays.sort(arr);
                    for (int l = 0; l < arr[0] - i; i++){
                        if (i+l == board.length-1 && j+l == board[0].length-1){
                            if(I>0 && PIECE>= length){
                                return true;
                            }
                            else{
                                return false;
                            }
                        }
                        else if (i+l == board.length-1) {
                            if (board[i+l - 1][j+l + 1] == piece && PIECE>= length){
                                return true;
                            }
                            else if (I>0 && PIECE>= length){
                                return true;
                            }
                            else return false;
                        }
                        else if (j+l == board[0].length-1) {
                            if (board[i+l + 1][j+l - 1] == piece && PIECE>= length){
                            return true;
                            }
                            else if (I>0 && PIECE>= length){
                            return true;
                            }
                            else return false;
                        }
                        else if (board[i+l+1][j+l+1] == piece){
                            PIECE++;
                        }
                        else if (board[i+l+1][j+l+1] != piece) {
                            if (PIECE >= length) {
                                if (board[i + l][j + l] == piece) {
                                    //??
                                    if (board[i + l + 1][j + l - 1] == piece) {
                                        return true;
                                    } else if (board[i + l - 1][j + l + 1] == piece) {
                                        return true;
                                    } else if (I > 0) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                                else {
                                    return false;
                                }
                            }
                            else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static boolean winInDiagonalForwardSlash (int[][] board, int piece, int length) {
        for (int i = 0; i < board.length; i++) {
            int PIECE = 1;
            int I = 0;
            for (int j = 0; j < board[0].length; j++) {
                //Checks for the first L shape
                if (board[i][j] == piece){
                    if (i == 0) {
                    }
                    else if (i == board.length - 1) {
                    }
                    else if (j == 0) {

                    }
                    else if (j == board[0].length-1) {

                    }
                    else if (board[i - 1][j + 1] == piece){
                        I++;
                    }
                    else if (board[i + 1][j - 1] == piece){
                        I++;
                    }
                    int[] arr = new int[2];
                    Arrays.sort(arr);

                    for (int l = 0; l < arr[0] - i; i++){
                        if (i+l == board.length-1 && j+l == board[0].length-1){
                            if(I>0 && PIECE>= length){
                                return true;
                            }
                            else{
                                return false;
                            }
                        }
                        else if (i+l == board.length-1) {
                            if (board[i+l - 1][j+l + 1] == piece && PIECE>= length){
                                return true;
                            }
                            else if (I>0 && PIECE>= length){
                                return true;
                            }
                            else return false;
                        }
                        else if (j+l == board[0].length-1) {
                            if (board[i+l + 1][j+l - 1] == piece && PIECE>= length){
                                return true;
                            }
                            else if (I>0 && PIECE>= length){
                                return true;
                            }
                            else return false;
                        }
                        else if (board[i+l-1][j+l-1] == piece){
                            PIECE++;
                        }
                        else if (board[i+l-1][j+l-1] != piece) {
                            if (PIECE >= length) {
                                if (board[i + l][j + l] == piece) {
                                    //??
                                    if (board[i + l + 1][j + l - 1] == piece) {
                                        return true;
                                    } else if (board[i + l - 1][j + l + 1] == piece) {
                                        return true;
                                    } else if (I > 0) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                                else {
                                    return false;
                                }
                            }
                            else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public static int[] hint(int[][] board, int piece, int length) {

        for (int j = 0; j < board[0].length; j++){
            if (canPlay(board,j) == true){
                play(board,j,piece);
                if (won(board,piece,length)){
                    removeLastPlay(board,j);
                    //Return the row and column hint for where to play the piece
                }
            }
            else {
                removeLastPlay(board,j);
            }
        }
        int [] arr = {-1,-1};
       return arr;
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
