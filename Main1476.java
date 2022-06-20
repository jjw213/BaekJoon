import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        Scanner sc = new Scanner(System.in);
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
//        int e=sc.nextInt();
//        int s=sc.nextInt();
//        int m=sc.nextInt();
//        System.out.println(e+","+s+","+m);
        int[] eArr = new int[15];
        int[] sArr = new int[28];
        int[] mArr = new int[19];
        int year=0;
//        boolean eTrue = true;
        int a = 1;
        int eCnt = 0;
        int sCnt = 0;
        int mCnt = 0;
        for(int x=0;x<eArr.length;x++){
            eArr[x]=x+1;
        }
        for(int y=0;y<sArr.length;y++){
            sArr[y]=y+1;
        }
        for(int z=0;z<mArr.length;z++){
            mArr[z]=z+1;
        }
        for (int i = 0; i < 7980; i++) {
//            do {
//                if (e == eArr[eCnt]) {
//                    do {
//                        if (s == sArr[sCnt]) {
//                            do {
//                                if (m == mArr[mCnt]) {
//                                    eTrue=false;
//                                }
//
//                            } while (eTrue);
//                        }
//                        sCnt++;
//                        if (sCnt == 29) eCnt = 1;
//                    } while (eTrue);
//                }
//                eCnt++;
//                if (eCnt == 16) eCnt = 1;
//            } while (eTrue);
            if(e==eArr[eCnt]){
                if (s==sArr[sCnt]){
                    if(m==mArr[mCnt]){
                        year=i+1;
                    }
                }
            }
            eCnt++;
            sCnt++;
            mCnt++;
            if(eCnt==15) eCnt=0;
            if(sCnt==28) sCnt=0;
            if(mCnt==19) mCnt=0;
        }
        System.out.println(year);
    }
}
