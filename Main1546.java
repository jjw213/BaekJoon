import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double best=0;
        double sum=0;
        double[] point = new double[n];
        br.read();
        String s = br.readLine();
        st = new StringTokenizer(s);

        for (int i=0;i<n;i++){
            point[i]= Double.parseDouble(st.nextToken());
            if(best<point[i]){
                best=point[i];
            }
        }
        for(int j=0;j<n;j++){
            sum+=point[j]/best*100;
        }
        System.out.println( sum/n);
    }
}
