import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main8958 {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        String[] ox = new String[n];
        int[] sum=new int[n];
        int prev=1;
//        br.read();
        for(int i=0;i<n;i++){
            String str=sc.next();
            ox[i]=str;

            for(int j=0;j<str.length();j++){
                if(ox[i].charAt(j)=='O'){
//                    System.out.println("sum"+i+"의 값 합 : "+sum[i]+"이고 j ="+j);
                    sum[i]+=prev;
                    prev++;
                }
                else {
                    prev=1;
                }
            }
            prev=1;
        }
        for(int k=0;k<n;k++)
            System.out.println(sum[k]);
    }
}
