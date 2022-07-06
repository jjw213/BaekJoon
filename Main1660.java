import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp1 = new int[122];
        int[] dp2 = new int[122];
        dp1[1] = 1;
        dp2[1] = 1;
        for (int i = 2; i < 122; i++) {
            dp1[i] = dp1[i-1] + i; // dp[2]=dp[1] +2 // dp[3]=dp[2]+3 => dp[1] +2+3 ...
            dp2[i] = dp1[i] + dp2[i-1]; // dp2[2] = dp1[2]+dp2[1]
        }
        System.out.println(dp2[121]);
        int[] res = new int[N+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= N; i++) {

            for (int j = 1; j < 122; j++) {
                if(dp2[j] > i) break;
                System.out.println("res["+i+"] = "+res[i]);
                System.out.println("res["+i+" - "+dp2[j]+"] = "+res[i - dp2[j]]);
                res[i] = Math.min(res[i], res[i - dp2[j]]+1);
                System.out.println("-----------");
            }
        }
        System.out.println(res[N]);
    }
}
