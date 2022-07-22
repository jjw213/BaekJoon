import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp1[] 은 각 포도주의 양
// dp2[] 는 그 포도주의 번 째까지 최대값
// 6, 10, 13, 9, 8, 1 의 값이 입력된다 치면
// dp2[0] = 6 이고  dp2[1] = 16 이다.
// dp2[2] 는 (dp2[1] 의 값과) (dp2[0] + dp1[2] 의 값과) (dp1[1]+dp1[2]의 값)의 크기를 비교한 후
// 더 큰 값으로 dp2[2]의 값을 설정한다. (따라서 dp2[2]는 23)
// dp2[3]은 (dp2[2] 의 값과) (dp2[1] + dp1[3] 의 값과) (dp2[0]+dp1[2]+dp1[3]의 값)의 크기를 비교한 후
// 더 큰 값으로 dp2[3]의 값을 설정한다. (따라서 dp2[3]는 28)
// dp2[4]은 (dp2[3] 의 값과) (dp2[2] + dp1[4] 의 값과) (dp2[1]+dp1[3]+dp1[4]의 값)의 크기를 비교한 후
// 더 큰 값으로 dp2[4]의 값을 설정한다. (따라서 dp2[4]는 33)

public class Main2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp1[i] = Integer.parseInt(st.nextToken());
        }
        dp2[0] = dp1[0];
        if (N == 1) {
            System.out.println(dp2[0]);
            return;
        }
        dp2[1] = dp1[0] + dp1[1];
        if (N == 2) {
            System.out.println(dp2[1]);
            return;
        }

        dp2[2] = Math.max(Math.max(dp2[1], dp2[0] + dp1[2]), dp1[1] + dp1[2]);
        for (int j = 3; j < N; j++) {
            dp2[j] = Math.max(Math.max(dp2[j - 1], dp2[j - 2] + dp1[j]), dp2[j - 3] + dp1[j - 1] + dp1[j]);
        }
        System.out.println(dp2[N - 1]);

    }
}
