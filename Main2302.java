// VIP석을 입력 받기 전 좌석을 옮기는 개수를 구하면 된다.
// 예를 들어 좌석이 9개이고, 4번 좌석과 7번 좌석이 VIP석인 경우에
// 123의 배치 방법 수(3개,123과 213과 132)와 56의 배치 방법 수(2개, 56과 65),
// 89의 배치 방법 수(2개, 89와 98)를 곱하면
// 12라는 총 가지 수가 나온다.
// 또한 5번 좌석과 7번 좌석이 VIP석이라면
// 1234의 배치 방법 수(5개, 1234와 1243과 1324와 2134와 2143)와 6의 배치 방법 수(1개)와
// 89의 배치 방법 수(2개, 89와 98)를 곱하면
// 10개의 총 가지 수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ans = 1;
// vip 좌석을 제외한 나머지 좌석의 경우의 수를 서로 곱함.
        int beforeSeat = 0;
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= dp[temp - beforeSeat - 1];
            beforeSeat = temp;
        }
        ans *= dp[N - beforeSeat]; // 마지막 vip 좌석 다음 좌석에서 끝 좌석까지의 경우의 수.
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
