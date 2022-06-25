import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaizaC113 {
    public static int P = 1;
    public static String R = "";
    public static int point=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
//        br.read();
        char[] mas = new char[n];
        int[] dice = new int[m];
        for (int i = 1; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            mas[i] = st.nextToken().charAt(0);
//            br.read();
        }
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            dice[j] = Integer.parseInt(st.nextToken());
//            br.read();
        }
        // 입력 다 받았고 이제 계산 후 출력
        result(mas, dice, point, 0);
        if (R.equals("goal")) {
            System.out.println(R);
            System.out.println(P);
        } else{
            System.out.println(R);
            System.out.println(point);
        }


    }

    public static void result(char[] mas, int[] dice, int p, int cnt) {
//        for(int i=0;i<dice.length;i++){
//
//
//        }
        if (cnt == dice.length) {
            R = "still";
            return;
        }
        point = p + dice[cnt];
//        System.out.println("dice="+dice[cnt]);
        if (point >= mas.length-1) {
            R = "goal";
            return;
        }

        switch (mas[point]) {
            case 'x':
                result(mas, dice, point, cnt + 1);
                break;
            case '-':
                result(mas, dice, point - 1, cnt + 1);
                break;
            case '+':
                result(mas, dice, point + 1, cnt + 1);
                break;
            case 'r':
                point=0;
                result(mas, dice, point, cnt + 1);
                break;
            default:
                result(mas, dice, point, cnt + 1);
        }
        P++;

    }
}
