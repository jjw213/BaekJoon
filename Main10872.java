import java.util.Scanner;

public class Main10872 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        int result=0;
        if(n<=1) result=1;
        else result=n*fact(n-1);
        System.out.println(result);
    }
    public static int fact(int n){
        if(n==1){
            return 1;
        }

        return n*fact(n-1);
    }
}
