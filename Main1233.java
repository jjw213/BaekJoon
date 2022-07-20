import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1233 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int answer = 1;

            for(int i = 1; i <= N; i++) {
                StringTokenizer st =  new StringTokenizer(br.readLine());

                st.nextToken(); // 첫 번째 정점 번호는 패스

                char node = st.nextToken().charAt(0);

                if(st.hasMoreTokens()) { // 단말 노드가 아닐 때
                    if(node >= '0' && node <= '9') { // 연산자여야 함, 숫자 X
                        answer = 0;
                    }
                } else { // 단말 노드일 때
                    if(node < '0' || node > '9') { // 숫자여야 함
                        answer = 0;
                    }
                }
            }
            sb.append("#" + test_case + " " + answer + "\n");
        }
        System.out.println(sb.toString());
    }

}