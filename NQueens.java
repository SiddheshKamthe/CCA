//Lab Assignment : 9
//Siddhesh Kamthe (RBT2IT123)

import java.util.*;
public class NQueens {
    public static void main(String[] args) {
        System.out.println("N Queens Problem");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        
        boolean[][] board = new boolean[n][n];
        System.out.println( queens(board, 0) );
        sc.close();
    }

    public static int queens( boolean[][] board, int row)   {
        if( row == board.length)    {
            display( board );
            System.out.println();
            return 1;
        }

        int count = 0;

        for(int col = 0; col < board.length; col++) {
            if( isSafe(board, row, col) )   {
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    //isSafe function to check whether the queen we are placing is at safe place or not
    public static boolean isSafe(boolean[][] board, int row, int col)   {
        for(int i = 0; i < row; i++)   {
            if( board[i][col] ){
                return false;
            }
        }

        //Diagonal left
        int maxLeft = Math.min( row, col);
        for(int i = 1; i <= maxLeft; i++)   {
            if( board[row - i][ col- i ])   {
                return false;
            }
        }

        //Diagonal right
        int maxRight = Math.min( row, board.length - col-1);
        for(int i = 1; i <= maxRight; i++){
            if( board[row - i][col + i])    {
                return false;
            }
        }

        return true;
    }
    //Display function to display board
    public static void display( boolean[][] board)  {
        for(boolean[] arr : board)  {
            for(boolean b : arr ) {
                if (b) {
                    System.out.print( " Q");
                }
                else {
                    System.out.print(" X");
                }
            }
            System.out.println();
        }
    }
}