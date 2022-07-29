import java.util.Scanner;

public class Main1673 {


    public static void main(String[] args) {

        // TODO Auto-generated method stub

        Scanner scan = new Scanner(System.in);


        while (true) {

            int n = scan.nextInt();

            int k = scan.nextInt();


            if (n == 0 && k == 0) {

                break;

            } else {

                int chicken = 0;

                chicken += n;

                while (n >= k) {

                    n = n / k;

                    chicken += n;

                }

                System.out.println(chicken);

            }

        }


    }


}