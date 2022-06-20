import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1106 {
    static final int INF = 987654321;
    static int c, n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken()); // 최소 고객
        n = Integer.parseInt(st.nextToken()); // 도시 개수

        dp = new int[c + 101]; // 달성 고객 + 최대 도시 고객
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); // 비용
            int customer = Integer.parseInt(st.nextToken()); // 고객
            for (int j = customer; j < c + 101; j++) {
                System.out.println("j값 : " +j +" dp값"+dp[j]);
                System.out.println( "dp[j-customer]값"+dp[j - customer]);
                dp[j] = Math.min(dp[j], cost + dp[j - customer]);
                System.out.println("dp값 : "+dp[j]);
            }
        }

        int ans = INF;
        for (int i = c; i < c + 101; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
//dp[113] customer=5