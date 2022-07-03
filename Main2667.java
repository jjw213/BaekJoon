import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2667 {
    public static int cnt = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[] house = new int[10001];

        for (int i = 0; i < N; i++) { // map 내용 입력
            st = new StringTokenizer(br.readLine());
            String stnt = st.nextToken();
            for (int j = 0; j < stnt.length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(stnt.charAt(j)));
            }
        }
//        for (int i = 0; i < N; i++) { // map 제대로 채워졌는지 검사
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = 0; i < N; i++) { // map 을 돌면서 map[i][j] == 1인 곳 찾아 cnt 값으로 변경시켜주기
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    dfs(map, i, j, house);
                    cnt++;
                }
            }
        }
        Arrays.sort(house); // 오름차순 정렬

        System.out.println(cnt - 2); // 총 단지 수 와 각 단지의 집 수 출력
        for (int i = 0; i < house.length; i++)
        {
            if(house[i]!=0)
                System.out.println(house[i]);
        }

    }

    public static void dfs(int[][] map, int row, int col, int[] house) {
        if (row < 0 || row == map.length || col < 0 || col == map[row].length) {
            return;
        }
        if (map[row][col] != 1) {
            return;
        }
        map[row][col] = cnt;
        dfs(map, row - 1, col, house);
        dfs(map, row + 1, col, house);
        dfs(map, row, col - 1, house);
        dfs(map, row, col + 1, house);
        house[cnt - 2] += 1; // cnt 번 째 단지의 집 수 +1
    }
}
