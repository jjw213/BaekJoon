import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
//        br.read();
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            word[i] = st.nextToken();
            if(i==n-1) br.read();
        }
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    if (o1==o2){
//                        o2=null;
                        return 0;
                    }
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i)==o2.charAt(i)){
                            continue;
                        }
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
//                if(o1.length()>o2.length()) {
//                    return 1;
//                }
//                else {
//                    return -1;
//                }
                return o1.length()-o2.length();
            }
        });
        for (int k=0;k<word.length;k++){
            if(k+1!=word.length){
                if(word[k].equals(word[k+1])) continue;
            }
            System.out.println(word[k]);
        }
    }
}
