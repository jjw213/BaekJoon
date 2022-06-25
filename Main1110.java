import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //
        int newNum=n;
        int ten=0;
        int one=0;
        int sum=0;
        int cnt=0;
        do{
            cnt++;
            ten=newNum/10;
            one=newNum%10;
            sum=ten+one;
            sum=sum%10;
            newNum=sum+(one*10);
        }while (n!=newNum);
        System.out.println(cnt);
    }
}
