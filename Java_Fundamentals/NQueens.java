public class NQueens {

    public static boolean isSafe(int[][] board, int row, int col)
    {
        int i = row;
        int j = col;

        // top-left;
        while(i >= 0 && j >= 0)
        {
            
            if(board[i][j] ==  1)
                return false;
            i--;
            j--;
        }

        // left
        j = col;
        while(j >= 0)
        {
            if(board[row][j] == 1)
                return false;
            j--;
        }

        // bottom=left
        i = row;
        j = col;
        while(i < board.length && j >=0)
        {
            if(board[i][j] == 1)
                return false;
            i++;
            j--;
        }

        return true;
    }
    public static boolean nQueens(int[][] board, int n, int col)
    {
        if(col >= n)
            return true;

        for(int i=0;i<n;i++)
        {
            if(isSafe(board, i, col))
            {
                board[i][col] = 1;
                boolean isValid = nQueens(board, n, col+1);
                if(isValid)
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    static void printBoard(int[][] board)
    {
        int n = board.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {   
                System.out.print(board[i][j] == 1 ? "Q " :  ". ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int n = 1;
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {   
                board[i][j] = 0;
            }
        }

        nQueens(board, n, 0);
        printBoard(board);

    }
}
