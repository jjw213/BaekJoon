// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    static int c=0;

    public static void main(String[] args) {
        String[] b1= {".##.#","#.#..","#...#","#.##."};
        String[] b2= {".#..#","##..#","...#."};
        for(int i=0;i<3;i++){
            System.out.println(countBattleships(b2)[i]);

        }
    }
    public static int[] countBattleships(String[] Oboard) {
        char[][] board=new char[Oboard.length][Oboard[0].length()];

        for (int i=0;i<Oboard.length;i++){
            for (int j=0;j<Oboard[i].length();j++){
                if(Oboard[i].charAt(j)=='.')
                    board[i][j]='.';
                else
                    board[i][j]='#';
            }
        }

        int[] cnt = new int[3];

        Arrays.fill(cnt, 0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '#') {
                    dfs(board, i, j);
                    if (c == 3)
                        cnt[2]++;
                    else if (c == 2)
                        cnt[1]++;
                    else
                        cnt[0]++;
                    c=0;
                }
            }
        }
        return cnt;
    }

    public static int dfs(char[][] board, int i, int j) {
        int row = i;
        int col = j;
        if (row < 0 || row == board.length || col < 0 || col == board[row].length) {
            return 0;
        }
        if (board[row][col] == '.' || board[row][col] == 'N') {
            return 0;
        }
        board[row][col] = 'N';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
        return c++;
    }
}
