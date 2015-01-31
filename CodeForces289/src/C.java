import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

/**
 * Created by kanghuang on 1/31/15.
 */
public class C {

    public static long find(int len, int k, long prevNum, int prevb, int b, long a, int digits[]){
        if (k + 1 == len){
            int lm = b - prevb;
            long cura = prevNum * 10 + lm;
            if (lm >= 0 && lm <= 9 && cura > a){
                return cura;
            }
            return -1;
        }

        for (int i = (digits[k] >= b ? 0: digits[k]); i <= 9; i++){
         //   System.out.print(digits[k]);
            long num = find(len, k + 1, prevNum * 10 + i, prevb + i, b , a, digits);
            if (num > 0){
                //System.out.println(i);
                digits[k] = i;
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int n;
        int[] digits = new int[40];
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        int count = 0;
        int len = 1;
        long prev = 0;
        for (int i = 0; i < n; i++){
            int b = reader.nextInt();
            long res;
//            for (int j = 0; j < digits.length; j++){
//                System.out.print(digits[i]);
//            }
            while ((res = find(len, 0, 0, 0, b, prev, digits)) < 0){
                len++;
            }

            prev = res;
           // System.out.println();
            System.out.println(res);
        }
    }

}
