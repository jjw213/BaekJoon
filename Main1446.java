//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main1446 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int D = Integer.parseInt(st.nextToken());
//        br.read();
//        st = new StringTokenizer(br.readLine());
//        int[][] drive = new int[N][3];
//        for(int i=0;i<N;i++){
//            drive[i][0]=Integer.parseInt(st.nextToken());
//            drive[i][1]=Integer.parseInt(st.nextToken());
//            drive[i][2]=Integer.parseInt(st.nextToken());
//        }
//        int min=0;
//        for (int i=0;i<drive.length;i++){
//            if(drive[i][0]!=D)
//                min=dfs(drive,i,0,D);
//        }
//    }
//    public static int dfs(int[][] drive,int point, int min,int D){
//        //
//        if(min==D) return min;
//        if(min>D) return 0;
//        min+=drive[point][2];
//        for (int i=point;i<=point;i++){
//            if(drive[i][0]==drive[i+1][0]){
//                min+=Math.min(drive[i][2],drive[i+1][2]);
//                drive[]
//            }
//        }
//        drive[point][0]=D;
//        return dfs(drive,drive[point][1],min,D);
//    }
//}
