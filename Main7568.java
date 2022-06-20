import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람
        int[][] name = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            name[i][1] = Integer.parseInt(st.nextToken()); // 키
        }
        int[] cnt= new int[n];
        Arrays.fill(cnt,1);
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (name[j][0] < name[k][0]) {
                    if (name[j][1] < name[k][1])
                        cnt[j]++;
                }
            }
        System.out.println(cnt[j]);
        }
    }
}
