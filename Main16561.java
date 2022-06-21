import java.util.Scanner;

public class Main16561 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=1;
        int cnt =2;
        for(int i=9;i<n;i+=3){
            sum+=cnt;
            cnt+=1;
        }
        System.out.println(sum);
    }
}
