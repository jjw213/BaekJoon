import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17478 {
    static int N=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        outPut(N, 0);

    }

    static void outPut(int n, int b){
        if(n==0){
            return;
        }
        str(b);
        System.out.println("\"재귀함수가 뭔가요?\"");
        str(b);
        System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        str(b);
        System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        str(b);
        System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        if(n==1){
            str(b+1);
            System.out.println("\"재귀함수가 뭔가요?\"");
            str(b+1);
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            close(n,b+1);
            System.out.println("____라고 답변하였지.");
            System.out.println("라고 답변하였지.");
        }
        outPut(n-1, b+1);

        return;
    }
    static void close(int n, int b){
        if (n==N) return;
        String underBar = "____";
        for(int i=b;i>0;i--){
            System.out.print(underBar);
        }
        System.out.println("라고 답변하였지.");

        close(n+1, b-1);
    }
    static void str(int b){
        String underBar = "____";
        for(int i=0;i<b;i++){
            System.out.print(underBar);
        }
    }
}
