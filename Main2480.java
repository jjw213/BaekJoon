import java.util.Scanner;

public class Main2480 {
    public static void main(String[] args) {
        int[] dice = new int[3];
        int best=0;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++){
            dice[i]=sc.nextInt();
        }

            if(dice[0]==dice[1]){
                if(dice[1]==dice[2]){ // 주사위 눈이 모두 같은 경우
                    System.out.println(10000+(dice[0]*1000));
                } // 주사위 첫번째랑 두번째가 같은 경우, 즉 2개 같은 경우
                else {
                    System.out.println(1000+(dice[0]*100));
                }
            } else if (dice[1]==dice[2]) { // 주사위 두번째랑 세번째가 같은 경우, 즉 2개 같은 경우
                System.out.println(1000+(dice[1]*100));
            } else if (dice[0]==dice[2]) { // 주사위 첫번째랑 세번째가 같은 경우, 즉 2개 같은 경우
                System.out.println(1000+(dice[0]*100));
            } else { //모두 다 다를 경우
                for(int j =0; j<3;j++){
                    if(best<dice[j]){
                        best=dice[j];
                    }
                }
                System.out.println(best*100);
            }


    }
}
