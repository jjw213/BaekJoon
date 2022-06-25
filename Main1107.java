import java.util.Scanner;

public class Main1107 {
    public static void main(String[] args) {
//        int c=100;
//        int n=0;
//        int m=0;
//        Scanner sc= new Scanner(System.in);
//        n=sc.nextInt();
//        int length = (int)(Math.log10(n)+1);
//        int[] a= new int[length];
//
//        for(int i =0 ;i<length;i++){
//            a[i]=n%10;
//        }
//        m=sc.nextInt();
//        int[] b= new int[m];
//        for(int j=0;j<m;j++){
//            b[j]=sc.nextInt();
//        }
//        int[] d=new int[a.length];
//        int cnt=0;
//        for(int k=0;k<a.length;k++){
//            for(int l=0;l<a.length;l++){
//                if(a[k]==b[l]){
//                    cnt++;
//                    d[k]=a[k];
//                }
//            }
//        }
//        if(cnt==0) System.out.println(length);
        Scanner scan = new Scanner(System.in);

        int target = scan.nextInt();
        int m = scan.nextInt();

        boolean[] broken = new boolean[10];
        for(int i = 0; i < m; i++) {
            int n = scan.nextInt();
            broken[n] = true;
        }

        int result = Math.abs(target - 100); //초기값 설정
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {

                if(broken[str.charAt(j) - '0']) { //고장난 버튼을 눌러야 하면
                    isBreak = true;
                    break; //더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; //i를 누른 후(len) target까지 이동하는 횟수(target - i)
                result = Math.min(min, result);
            }
        }
        System.out.println(result);

    }
}
