package PathPlanning;

import java.util.Scanner;

public class P2D {

    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt(), c = num;
        while(c != 0) {
            int cop = c, len = 0;
            while(cop != 0) { cop /= 10; len++; }
            cop = num;
            for (int i = 0; i<len-1; i++) cop /= 10;
            System.out.println(cop%10);
            c /= 10;
        }
    }

}
