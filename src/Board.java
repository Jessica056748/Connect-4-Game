import java.util.Arrays;
/**
 * CPSC 233 W24 Assignment 1 February 10 2024
 * @author Jessica Truong, Jonathan Hudson
 * @ email jessica.truong1@ucalgary.ca , jwhudson@ucalgary.ca
 * Tutorial 15
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

    /**
     * createBoard function by taking in the number of rows and columns from user
     * and then using that to generate a 2D array while inputting EMP at each location
     */
    public static int[][] createBoard(int rows, int columns) {
        int[][] board = new int[rows][columns];
        //for loop where x is for row and j is for column to make a board with all EMP piece
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = EMP;
            }
        }
        return (board);
    }

    /**
     * rowCount function that takes in a 2D array board and determining
     * the length of the board which is the length of the board and then returning that
     */
    public static int rowCount(int[][] board) {
        return board.length;
    }

    /**
     * columnCount function that takes in a 2D array board and determining the number
     * of columns by determining the length of the first row
     * which would give the length of the column and then returning the number of columns
     */
    public static int columnCount(int[][] board) {
        //finding the length of a column using the length of row 0
        return board[0].length;
    }

    /**
     * valid function looks at the inputted row and column values that outputs false if the
     * values are less than 0 and if the values inputted are less than the values of the
     * board size and then returning true or false depending on if the input values are possible
     */
    public static boolean valid(int[][] board, int row, int column) {
        //checking for any row or column that is negative and anything above the size of the board
        if (row < 0) {
            return (false);
        } else if (column < 0) {
            return (false);
        } else if (row > board.length - 1) {
            return (false);
        } else if (column > board[0].length - 1) {
            return (false);
        } else {
            return (true);
        }
    }

    /**
     * canPlay function determines if there are empty spaces in the inputted column and then
     * outputing true or false depending on if it is possible
     */
    public static boolean canPlay(int[][] board, int column) {
        // for loop where j is the row, it is searching for an EMP spot
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] == EMP) {
                return (true);
            }
        }
        return false;
    }

    /**
     * play function that takes the piece and column inputted and adds the piece to the
     * indicated column at the next available spot in the column by replacing EMP with the piece
     * then it returns the index of the row where it was placed
     */
    public static int play(int[][] board, int column, int piece) {
        //for loop looking for an EMP spot, in the column starting at the bottom working upwards
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column] == EMP) {
                board[row][column] = piece;
                return row;
            }
        }
        return -1;
    }

    /**
     * removeLastPlay function removes the highest piece/ last piece played in the indicated column
     * by replacing the piece with EMP
     */
    public static int removeLastPlay(int[][] board, int column) {
        //for loop where it looks for any 1 or 2 and replaces with EMP
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] == 1 || board[row][column] == 2) {
                board[row][column] = EMP;
                return row;
            }
        }
        return -1;
    }

    /**
     * full function checks if the board is full through a for loop of the row and a for loop within
     * for column which will check at each spot if there is an EMP otherwise return false to indicate
     * that the board is full
     */
    public static boolean full(int[][] board) {
        //for loop where it checks each position
        //for loop checks for any EMP spots, if there are, then it returns false
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == EMP) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * winInRow function checks at the indicated row to see if the indicated piece has
     * in a row that adds up to at least the length indicated. It then checks to see if that colored piece
     * with the length needed created an L this would return true, otherwise it would return false
     */
    public static boolean winInRow(int[][] board, int row, int piece, int length) {
        int left = 0;
        // while loop to move left over until that spot is == piece or left is 1 away from the end
            while (board[row][left]!= piece && left < board[row].length-2){
                    left++;
                }
            int right = left + 1;

            //while loop to when there is a piece that is length long
            while(right-left < length-1) {

                //If statement to check all both left and right are = piece, keep pushing until enough length
                //else checks if the right is piece, if not then restart left and right
                if(board[row][left]==piece && board[row][right]==piece) {
                        right++;
                        // if right is at past end then return false
                    if(right>=board[0].length) {
                        return false;
                        }
                    // checks if the right is piece, if not then restart left and right
                    else if (board[row][right]!=piece){
                        left = right + 1;
                        right = left + 1;
                    }
                    }

                else {
                    left = right + 1;
                    right = left + 1;

                    if(right>=board[0].length) {
                        return false;
                    }
                }
                if(right+1<board[0].length){
                    if (board[row][right+1]==piece){
                        right++;
                    }
                }

                if(right>=board[0].length) {
                    return false;
                }

            }
            //Check above and below, front and back, for L
            boolean checkAbove = false;
            boolean checkBelow = false;
            boolean checkAbove1 = false;
            boolean checkBelow1 = false;

            //checks for when row==0, r is at the end and in between for above and below to find L
            if (row == 0){
                checkBelow1 = (board[row+1][left]==piece|| (board[row+1][right]==piece));
            }
            else if (row == board.length -1){
                checkAbove1 = (board[row-1][left]==piece) || (board[row-1][right]==piece);
            }
            else{
                checkAbove = (board[row-1][left]==piece) || (board[row-1][right]==piece);
                checkBelow = (board[row+1][left]==piece) || (board[row+1][right]==piece);

            }
            if(checkAbove || checkBelow ||checkAbove1||checkBelow1) {
                return true;
            }
        return false;
    }


    /**
     * winInColumn function checks in the indicated column if there are the piece indicated
     * in a row that adds up to at least the inputted length. If it does, then it will check if those
     * pieces in a row make an L, this will return true, otherwise false
     */
    public static boolean winInColumn(int[][] board, int column, int piece, int length) {
        // while loop to move up over until that spot is == piece or up is 1 away from the end
            int up = 0;
            while (board[up][column]!= piece && up<board.length-2){
                up++;
            }
            int down = up+1;

            //while loop to when there is a piece that is length long
            while(down-up < length-1) {

                //If statement to check all both up and down are = piece, keep pushing until enough length
                //else checks if the down is piece, if not then restart up and down
                if(board[up][column]==piece && board[down][column]==piece) {
                    down++;
                    if(down>=board.length) {
                        return false;
                    }
                    else if (board[down][column]!=piece){
                        up = down + 1;
                        down = up + 1;
                    }
                }
                else {
                    up = down + 1;
                    down = up + 1;
                    if(down>=board.length){
                        return false;
                    }
                }
                if (down+1< board.length){
                    if (board[down+1][column] == piece){
                        down++;
                    }
                }

                if(down>=board.length) {
                    return false;
                }

            }
            //Check above and below, front and back, for  L
            boolean checkAbove = false;
            boolean checkBelow = false;
            boolean checkAbove1 = false;
            boolean checkBelow1 = false;

        //checks for when row==0, r is at the end and in between for above and below to find L
        if (column == 0){
                checkBelow1 = (board[up][column+1]==piece|| (board[down][column+1]==piece));
            }
            else if (column == board[0].length -1){
                checkAbove1 = (board[up][column-1]==piece) || (board[down][column-1]==piece);
            }
            else{
                checkAbove = (board[up][column-1]==piece) || (board[down][column-1]==piece);
                checkBelow = (board[up][column+1]==piece|| (board[down][column+1]==piece));

            }

            if(checkAbove || checkBelow ||checkAbove1||checkBelow1) {
                return true;
            }
            return false;
        }
    /**
     * winInDiagonalBackslashfunction checks to see if there is any backslash diagonal win by looking for
     * the inputted piece in a row that is at least the length indicated. then it will look
     * an "L" in the pieces that were in a row where if it does, then it will return true
     */
    public static boolean winInDiagonalBackslash(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                // PIECE counts the number of 1 or 2 that are consecutive
                int PIECE = 1;
                //Checks for when there is the short side of the L at the first position of piece found
                int shortSideOfL = 0;
                // for loop to check each column
                //Checks for the first L shape
                if (board[row][column] == piece) {
                    //if else Checks for the first short side of L shape where it adds one to shortsideofL if found
                    // eliminates doing anything for the 4 corner coordinates
                    if (row == 0) {
                        if (column == 0 || column == board[0].length-1){
                        }
                        else if (board[row + 1][column - 1] == piece) {
                            shortSideOfL++;
                            }
                        }
                    else if (row == board.length - 1) {
                        if (column == 0 || column == board[0].length - 1) {
                        }
                        else if (board[row - 1][column + 1] == piece) {
                            shortSideOfL++;
                        }
                    }
                    else if (column == board[0].length-1) {
                             if (board[row + 1][column - 1] == piece) {
                                 shortSideOfL++;
                             }
                         }
                    else if (column ==0){
                        if (board[row - 1][column + 1] == piece) {
                            shortSideOfL++;
                        }
                    }
                    else if (board[row + 1][column - 1] == piece) {
                        shortSideOfL++;
                        }

                    else if (board[row - 1][column + 1] == piece) {
                        shortSideOfL++;
                        }
                        //arr to find the shortest side of row or column, then this would be where it needs to stop for the for loop
                    int[] arr = {board.length, board[0].length};
                    Arrays.sort(arr);
                    //for loop to find the consecutive pieces and checking for short side of L when the next spot is not the same piece
                    // if statements to eliminate those two sides because they would not be able to form a diagonal with those starting pieces
                    if (row != board.length-1) {
                        if (column != board[0].length-1) {
                            int[]shortestLength = {row,column};
                            Arrays.sort(shortestLength);
                            //counter to go up
                            for(int l = 0; l< arr[0]-shortestLength[1] ; l++) {
                                //checks the spot to see if it is at the end
                                if (column + l == board[0].length - 1) {
                                    if (shortSideOfL > 0 && PIECE >= length) {
                                        return true;
                                    } else if (row == 0 && column == 0) {

                                    } else if (board[row + 1][column - 1] == piece) {
                                        if (PIECE >= length) {
                                            return true;
                                        }
                                    }
                                } else if (row + l == board.length - 1) {
                                    if (board[row + l - 1][column + l + 1] == piece && PIECE >= length) {
                                        return true;
                                    } else if (shortSideOfL > 0 && PIECE >= length) {
                                        return true;
                                    }
                                }
                                else if (board[row + l + 1][column + l + 1] == piece) {
                                    PIECE++;

                                } else if (board[row + l + 1][column + l + 1] != piece) {
                                    if (PIECE >= length) {
                                        if (board[row + l][column + l] == piece) {
                                            if (board[row + l + 1][column + l - 1] == piece) {
                                                return true;
                                            } else if (board[row + l - 1][column + l + 1] == piece) {
                                                return true;
                                            } else if (shortSideOfL > 0) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        return false;
    }
    /**
     * winInDiagonalForwardslashfunction checks to see if there is any forward diagonal win by looking for
     * the inputted piece in a row that is at least the length indicated. then it will look
     * an "L" in the pieces that were in a row, it will return true if this is met
     */
    public static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                // PIECE counts the number of 1 or 2 that are consecutive
                int PIECE = 1;
                //Checks for when there is the short side of the L at the first position of piece found
                int shortSideOfL = 0;
                // for loop with check each column
                //Checks for the first L shape
                if (board[row][column] == piece) {
                    //if else Checks for the first short side of L shape where it adds one to shortsideofL if found
                    // eliminates doing anything for the 4 corner coordinates
                    if (row == 0) {
                        if (column == 0 || column == board[0].length-1){
                        }
                        else if (board[row + 1][column + 1] == piece) {
                            shortSideOfL++;
                        }
                    }
                    else if (row == board.length - 1) {
                        if (column == 0 || column == board[0].length - 1) {
                        }
                    }
                    else if (column == board[0].length-1) {
                        if (board[row - 1][column - 1] == piece) {
                            shortSideOfL++;
                        }
                    }
                    else if (column ==0) {

                    }
                    else if (board[row - 1][column - 1] == piece) {
                        shortSideOfL++;
                    }

                    else if (board[row + 1][column + 1] == piece) {
                        shortSideOfL++;
                    }
                    //arr to find the shortest side of row or column, then this would be where it needs to stop for the for loop
                    int[] arr = {board.length, board[0].length};
                    Arrays.sort(arr);

                    //for loop to find the consecutive pieces and checking for short side of L when the next spot and also when the next piece is not the same piece
                    // if statements to eliminate those two sids because they would not be able to form a diagonal with those starting pieces
                    if (row != board.length-1) {
                        if (column != 0) {
                            int[] shortestLength = {row,column};
                            //used to create the range for the for loop
                            int middlePoint = (board[0].length)/2;
                            middlePoint = middlePoint-1;

                            int boardRange;
                            if (column>middlePoint){
                            boardRange = arr[0];
                            }
                            else {
                                boardRange = middlePoint+1;
                            }

                            for (int l = 0; l<(boardRange)-shortestLength[0]; l++){
                                //checks the spot to see if it is at the end
                                if (column - l == 0) {
                                    if (shortSideOfL > 0 && PIECE >= length) {
                                        return true;
                                    }
                                    else if (row+l == board.length-1) {
                                        if (shortSideOfL > 0 && PIECE >= length) {
                                            return true;
                                        }
                                    }
                                    //is this right??
                                    else if (board[row + l +1][column+1] == piece){
                                            if (PIECE >= length) {
                                                return true;
                                            }
                                    }
                                }
                                else if (row + l == board.length-1) {
                                    if (board[row + l - 1][column - l - 1] == piece && PIECE >= length) {
                                        return true;

                                    } else if (shortSideOfL > 0 && PIECE >= length) {
                                        return true;
                                    }
                                }
                                else if (board[row + l + 1][column - l - 1] == piece) {
                                    PIECE++;

                                } else if (board[row + l + 1][column - l - 1] != piece) {
                                    if (PIECE >= length) {
                                        if (board[row + l][column - l] == piece) {
                                            if (board[row + l + 1][column - l + 1] == piece) {
                                                return true;
                                            } else if (board[row + l - 1][column - l - 1] == piece) {
                                                return true;
                                            } else if (shortSideOfL > 0) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        return false;
    }

    /**
     * hint function lets the user decide where to put their piece next to determine if the opponent will win
     * any of the spots in the next round and indicating to the player to put their piece there to stop the
     * opponent from winning as well as indicating where there might be a win next
     */
    public static int[] hint(int[][] board, int piece, int length) {
        // for loop to check for empty spots, then plays at the indicated spot
        // if won returns true then it will return the coordinates, else remove it and go to the next j (column) value
        for (int column = 0; column < board[0].length; column++){
            if (canPlay(board,column) == true){
                play(board,column,piece);
                if (won(board,piece,length) ==true){
                    removeLastPlay(board,column);
                    int [] rowAndColumn = {play(board,column,piece),column};
                    return rowAndColumn;
                }
                else {
                    removeLastPlay(board,column);
                }
            }
        }
        //return {-1,-1} if nothing found
        int [] array = {-1,-1};
        return array;
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
