import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs로 하나의 울타리 범위를 찾고 그 안 쪽 영역의 좌표를 저장한다.
// 저장한 좌표들이 . 인지 V인지 O인지 확인하여
// 하나의 영역 안의 늑대와 양의 수를 확인할 수 있다.
public class Main3184 {
    static int cntO=0;
    static int cntV=0;
    public static void main(String[] args) throws IOException {
        int printCntO = 0, printCntV=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] garden = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < C; j++) {
                garden[i][j] = str.charAt(j);
            }
        }
        // garden 안을 탐색하다가
        // o(양)을 찾으면
        // 양이 갈 수 있는 . 과 o, v 그리고 양이 갈 수 없는 #
        // 빠져나갈 수 있을 때까지 dfs
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(garden[i][j]=='o'||garden[i][j]=='v')
                {
                    dfs(garden, i, j);
                    // 한 개 규모의 울타리 안에
                    if(cntO>cntV) // 양이 늑대보다 많다면 늑대 수 = 0
                        cntV=0;
                    else // 늑대가 양보다 많거나 같다면 양의 수 = 0
                        cntO=0;
                    // 출력 결과에 양과 늑대의 수 적립
                    printCntO+=cntO;
                    printCntV+=cntV;
                    // 카운트 초기화
                    cntV=0;
                    cntO=0;
                }
            }
        }

        System.out.println(printCntO +" "+printCntV);
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(garden[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void dfs(char[][] garden, int row, int col) {
        // 배열의 범위를 넘었을 경우
        if (row < 0 || row == garden.length || col < 0 || col == garden[row].length) {
            return;
        }
        // 울타리로 막힌 길이거나 이미 지나온 길일 경우
        if (garden[row][col] == '#' || garden[row][col] == '@'
                || garden[row][col] == 'O'|| garden[row][col] == 'V') {
            return;
        }
        // 지나온 길 표시
        if(garden[row][col]=='o')
        {
            cntO++;
            garden[row][col] = 'O';
        }
        else if(garden[row][col]=='v') {
            cntV++;
            garden[row][col] = 'V';
        }
        else
            garden[row][col] = '@';
        // 상하좌우 탐색
        dfs(garden, row - 1, col);
        dfs(garden, row + 1, col);
        dfs(garden, row, col - 1);
        dfs(garden, row, col + 1);

    }
}
