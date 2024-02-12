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
     * createBoard function through taking in the number of rows and columns
     * and then using that to generate a 2D array while inputting EMP at each location
     */
    public static int[][] createBoard(int rows, int columns) {
        int[][] board = new int[rows][columns];
        //for loop where x is for row and j is for column to make a board with all EMP piece
        for (int x = 0; x < rows; x++) {
            for (int j = 0; j < columns; j++) {
                board[x][j] = EMP;
            }
        }
        return (board);
    }

    /**
     * rowCount function that takes in a 2D array board and determining
     * the length of the board which is the length of the board and then returning that
     */
    public static int rowCount(int[][] board) {
        int ROW = board.length;
        return ROW;
    }

    /**
     * columnCount function that takes in a 2D array board and determining the number
     * of columns by determining the length of the first row
     * which would give the length of the column and then returning the number of columns
     */
    public static int columnCount(int[][] board) {
        //finding the length of a column using the length of row 0
        int COLUMN = board[0].length;
        return COLUMN;
    }

    /**
     * valid function looks at the inputted row and column values that outputs false if the
     * values are less than 0 and if the values inputted are less than the values of the
     * board size and then returning true or false depending on if the input values are possible
     */
    public static boolean valid(int[][] board, int row, int column) {
        //checking for any row or column that is negative and anythig above the size of the board
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
        for (int j = 0; j < board.length; j++) {
            if (board[j][column] == EMP) {
                return (true);
            }
        }
        return false;
    }

    /**
     * play function that takes the piece and column inputted and adds the piece to the
     * indicated column at the next avalible spot in the column by replacing EMP with the piece
     * then it returns the index of the row where it was placed
     */
    public static int play(int[][] board, int column, int piece) {
        // j is for the rows
        //for loop looking for an EMP spot, in the column starting at the bottom working upwards
        for (int j = board.length - 1; j >= 0; j--) {
            if (board[j][column] == EMP) {
                board[j][column] = piece;
                return j;
            }
        }
        return -1;
    }

    /**
     * removeLastPlay function removes the highest piece/ last piece played in the indicated column
     * by replacing the piece with EMP
     */
    public static int removeLastPlay(int[][] board, int column) {
        //for loop where j is for row, it looks for any 1 or 2 and replaces with EMP
        for (int j = 0; j < board.length; j++) {
            if (board[j][column] == 1 || board[j][column] == 2) {
                board[j][column] = EMP;
                return j;
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
        //for loop where it checks each position (i is for row, j is for column)
        //for loop checks for any EMP spots, if there are, then it returns false
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == EMP) {
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
//        for(int left = 0; left < board[0].length-2; left++) {
        int left = 0;
        // while loop to move left over until that spot is == piece or left is 1 away from the end
            while (board[row][left]!= piece && left<board[row].length-2){
                    left++;
                }
            int right = left+1;

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
                //
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

//            if (row!=0) {
//                checkAbove = (board[row-1][left]==piece) || (board[row-1][right]==piece);
//            }
//            else if(row!=board.length-1) {
//                checkBelow = (board[row+1][left]==piece) || (board[row+1][right]==piece);
//            }
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

//        }
        return false;

    }


        /**
         * winInColumn function checks in the indicated column if there are the piece indiciated
         * in a row that adds up to at least the inputted length. If it does, then it will check if those
         * pieces in a row make an L, this will return true, otherwise false
         */
    public static boolean winInColumn(int[][] board, int column, int piece, int length) {
        // while loop to move left(up) over until that spot is == piece or left is 1 away from the end
        //right is down
//        for(int left = 0; left < board[0].length-2; left++) {
            int left = 0;
            while (board[left][column]!= piece && left<board.length-2){
                left++;
            }
            int right = left+1;

            //while loop to when there is a piece that is length long
            while(right-left < length-1) {

                //If statement to check all both left and right are = piece, keep pushing until enough length
                //else checks if the right is piece, if not then restart left and right
                if(board[left][column]==piece && board[right][column]==piece) {
                    right++;
                    if(right>=board.length) {
                        return false;
                    }
                    else if (board[right][column]!=piece){
                        left = right + 1;
                        right = left + 1;
                    }
                }
                else {
                    left = right + 1;
                    right = left + 1;
                    if(right>=board.length){
                        return false;
                    }
                }
                if (right+1< board.length){
                    if (board[right+1][column] == piece){
                        right++;
                    }
                }

                if(right>=board.length) {
                    return false;
                }

            }
            //Check above and below, front and back, for  L
            boolean checkAbove = false;
            boolean checkBelow = false;
            boolean checkAbove1 = false;
            boolean checkBelow1 = false;

//            if (row!=0) {
//                checkAbove = (board[row-1][left]==piece) || (board[row-1][right]==piece);
//            }
//            else if(row!=board.length-1) {
//                checkBelow = (board[row+1][left]==piece) || (board[row+1][right]==piece);
//            }

        //checks for when row==0, r is at the end and in between for above and below to find L
        if (column == 0){
                checkBelow1 = (board[left][column+1]==piece|| (board[right][column+1]==piece));
            }
            else if (column == board[0].length -1){
                checkAbove1 = (board[left][column-1]==piece) || (board[right][column-1]==piece);
            }
            else{
                checkAbove = (board[left][column-1]==piece) || (board[right][column-1]==piece);
                checkBelow = (board[left][column+1]==piece|| (board[right][column+1]==piece));

            }

            if(checkAbove || checkBelow ||checkAbove1||checkBelow1) {
                return true;
            }


//        }
            return false;

        }
    /**
     * winInDiagonalBackslashfunction checks to see if there is any backslash diagonal win by looking for
     * the inputted piece in a row that is at least the length indicated. then it will look
     * an "L" in the pieces that were in a row where if it does, then it will return true
     */
    public static boolean winInDiagonalBackslash(int[][] board, int piece, int length) {
        for (int i = 0; i < board.length; i++) {
            // PIECE counts the number of 1 or 2 that are consecutive
            int PIECE = 1;
            //I checks for when there is the short side of the L at the first position of piece found

            int I = 0;
            // for loop with j has the column to check each column

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
                    //arr to find the shortest side of row or column, then this would be where it needs to stop for the for loop
                    int [] arr= new int[2];
                    Arrays.sort(arr);
                    //for statement to find the consecutive piece and checking for short side of L when the next spot is not the same piece
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
    /**
     * winInDiagonalForwardslashfunction checks to see if there is any forward diagonal win by looking for
     * the inputted piece in a row that is at least the length indicated. then it will look
     * an "L" in the pieces that were in a row, it will return true if this is met
     */
    public static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {
        //for loop with i being rows , to check for piece in each row
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // PIECE counts the number of 1 or 2 that are consecutive
                int PIECE = 1;
                //I checks for when there is the short side of the L at the first position of piece found
                int I = 0;
                // for loop with j has the column to check each column
                if (board[i][j] == piece){
                    //if else Checks for the first short side of L shape where it adds one to I if found
                    if (i == 0) {
                        if(j==0){
                        }
                        else if (j == board[0].length-1){
                        }
                        else if (board[i+1][j+1] == piece){
                            I++;
                        }
                    }
                    else if (i == board.length - 1) {
                    }
                    else if (j == 0) {
                        if(i==0){
                        }
                        else if (i == board.length-1){
                        }
                        else if (board[i+1][j+1] == piece){
                            I++;
                        }
                    }
                    else if (j == board[0].length-1) {
                        if (board[i - 1][j - 1] == piece){
                            I++;
                        }
                    }
                    else if (board[i + 1][j + 1] == piece){
                        I++;
                    }
                    else if (board[i - 1][j - 1] == piece){
                        I++;
                    }
                    //arr to find the shortest side of row or column, then this would be where it needs to stop for the for loop
                    int[] arr = {board.length , board[0].length};
                    Arrays.sort(arr);
                    //for statement to find the consecutive piece and checking for short side of L when the next spot is not the same piece
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
                            if (board[i+l - 1][j+l - 1] == piece && PIECE>= length){
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


    /**
     * hint function lets the user decide where to put their piece next to determine if the opponent will win
     * any of the spots in the next round and indicating to the player to put their piece there to stop the
     * opponent from winning as well as indicating where there might be a win next
     */
    public static int[] hint(int[][] board, int piece, int length) {
        // for loop to check for empty spots, then plays at the indicated spot
        // if won returns true then it will return the coordinates, else remove it and go to the next j (column) value
        for (int j = 0; j < board[0].length; j++){
            if (canPlay(board,j) == true){
                play(board,j,piece);
                if (won(board,piece,length)){
                    removeLastPlay(board,j);
                    int [] row = {play(board,j, piece),j};
                    return row;
                }
                else {
                    removeLastPlay(board,j);
                }
            }

        }
        //return {-1,-1} if nothing found
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
