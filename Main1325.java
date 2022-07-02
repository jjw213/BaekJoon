import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
//        br.read();
        for (int i = 0; i < M; i++) {
            // 3 1 을 입력받았을 경우
            // 1 은 3으로 갈 수 있기에
            // arr[0] = {0, 0, 1, 0, 0} 이 돼야 함.
            // 같은 원리로 4 3 과 5 3 을 입력 받았다면
            // 3은 4와 5로 갈 수 있기에
            // arr[2] = {0, 0, 0, 1, 1} 이 됨.
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[B - 1][A - 1] = 1;
        }

        int best = 0;
        int[] num = new int[N];

        for (int i = 0; i < N; i++) { // 행의 크기만큼 반복
            for (int j = 0; j < arr[i].length; j++) { //열의 크기만큼 반복
                if (arr[i][j] == 1) { // 연결된 컴퓨터 발견 시 그 행의 "열 번호(j)"를 dfs의 행 인자(row)로 넘겨줌,
                    int a = dfs(arr, 0, j, 0, N); //  dfs의 return 값은 연결된 컴퓨터가 몇 대인지
                    if (best <= a) //i 번째 컴퓨터와 연결된 컴퓨터 수가 최고기록 갱신 했다면
                    {
                        best=a; // 최고기록 갱신하고
                        num[i] = a; // num 배열에 연결된 컴퓨터 수를 넣어줌.(왜냐? print할 때 최고 기록인 컴퓨터만 print 하기 위해)
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) { // 출력 부분
            if (num[i] >= best)
                System.out.print(i+1+" ");
        }
    }

    public static int dfs(int[][] arr, int col, int row, int cnt, int N) {
        if (row == N) return cnt++; // 마지막 행까지 다 훑어봄.

        if (col+1 == arr[row].length && arr[row][col]==0) { // 마지막 열이면서 그 열의 값이 0(연결된 컴퓨터 없음)이면
            return cnt++; // 더이상 찾을 필요 없이 종료
        }
        if (arr[row][col] == 0)
            return dfs(arr, col+1, row, cnt, N); // 이 행의 열에 연결된 컴퓨터가 없으면 다음 열 탐색

        //여기까지 왔단 것은 이 행과 열(row와 col) 번호로 연결된 컴퓨터가 있다는 뜻이므로
        cnt++;
        return dfs(arr, 0, col, cnt, N); // 그 열의 번호(col)를 dfs의 row 인자로 넘겨서 계속 탐색할 수 있게끔
    }
}
