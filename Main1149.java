import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int house = Integer.parseInt(st.nextToken());
        br.read();
        int[][] rgb = new int[house][3];
        for(int i=0;i<house;i++){
            st=new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
            if(i!=house-1) br.read();
        }
//        for(int j=0;j<house;j++) {
//            System.out.println(rgb[j][0]);
//        }
            int result = Math.min(Math.min(rCost(rgb, house-1),gCost(rgb,house-1)),bCost(rgb,house-1));
            System.out.println(result);
//        }


    }
    public static int rCost(int[][] rgb, int house){
        if(house<0) return 0;
        int r=rgb[house][0];
//        System.out.println("house "+house+"의 r 값 :"+r);
        return Math.min(gCost(rgb,house-1),bCost(rgb,house-1))+r;
    }
    public static int gCost(int[][] rgb, int house){
        if(house<0) return 0;
        int g=rgb[house][1];
//        System.out.println("house "+house+"의 g 값 :"+g);
        return Math.min(rCost(rgb,house-1),bCost(rgb,house-1))+g;
    }
    public static int bCost(int[][] rgb, int house){
        if(house<0) return 0;
        int b=rgb[house][2];
//        System.out.println("house "+house+"의 b 값 :"+b);
        return Math.min(rCost(rgb,house-1),gCost(rgb,house-1))+b;
    }
}
