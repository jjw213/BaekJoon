import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1890 {
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        //N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        //입력 받은 N 값으로 N*N 크기 board 2차원 배열 만들기
        int[][] board = new int[N][N];
        //board 배열 채워넣기
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(board,0,0);
        System.out.println(cnt);
    }
    public static void dfs(int[][] board, int row, int col){
        if( row>=board.length || col>=board[row].length)
            return;
        if( board[row][col] == 0)
        {
            cnt++;
            return;
        }
        //오른쪽 아래 가는 방향 재귀
        int size = board[row][col];
        dfs(board,row+size,col);
        dfs(board,row,col+size);

    }
}
