import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1743 {
    static int c=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] trash=new int[n][m];
//        br.read();
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trash[x-1][y-1]=1;
        }
        int best =0;
        for (int i = 0; i < trash.length; i++) {
            for (int j = 0; j < trash[i].length; j++) {
                if (trash[i][j] == 1) {
                    dfs(trash, i, j);
                    if(c>best) best=c;
                    c=0;
                }
            }
        }
        System.out.println(best);
    }
    public static int dfs(int[][] board, int i, int j) {
        int row = i;
        int col = j;
        if (row < 0 || row == board.length || col < 0 || col == board[row].length) {
            return 0;
        }
        if (board[row][col] == 0 || board[row][col] == 2) {
            return 0;
        }
        board[row][col] = 2;
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
        return c++;
    }
}
