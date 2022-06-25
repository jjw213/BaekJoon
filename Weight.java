import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Weight {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("추의 총 개 수 입력: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextByte();
        int[] A = new int[n];
        System.out.println("무게 입력: ");
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextByte();
        }
        //----------------------
        int min = Cal(n, A);
        System.out.println("최솟값은 "+min+" 입니다!");
    }

    public static int Cal(int n, int[] A) {
        int min = 0;
        int left = 0;
        int right = 0;
        boolean r_first = true;
//        int sum=0;
//        for (int i = 0; i < A.length; i++) {
//            sum+=A[i];
//        }
//        double avg=sum/A.length;
//
//        double div = avg*2;
        Arrays.sort(A);
        for (int j = n-1; j > 0; j -= 2) {
            if (r_first) {
                right += A[j];
                left += A[j - 1];
            } else {
                right += A[j - 1];
                left += A[j];
            }
            if (right > left)
                r_first = false;
            else r_first = true;
        }
        System.out.println("왼쪽 무게는 "+left);
        System.out.println("오른쪽 무게는 "+right);
        if (r_first) {
            min = left - right;
            return min;
        }
        else {
            min = right - left;
            return min;
        }
    }
}
