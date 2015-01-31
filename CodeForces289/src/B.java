import java.util.Scanner;

/**
 * Created by kanghuang on 1/31/15.
 */
public class B {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n, k;
        int [] b = new int[110];

        n = reader.nextInt();
        k = reader.nextInt();
        int i = 0;
        int min = Integer.MAX_VALUE, max = 0;
        for (; i < n; i++){
            b[i] = reader.nextInt();
            min = Math.min(b[i], min);
            max = Math.max(b[i], max);
        }
        if (Math.ceil((max - min) * 1.0/k) > 1){
            System.out.print("NO");
        }
        else {
            System.out.println("YES");
            for (i = 0; i < n; i++) {
                int Exceed = b[i] % k;
                int base = b[i] / k;
                int count = 0, color = 1;
                while(count < b[i]){
                    int m = base + (color > Exceed?0:1);
                    for (int j = 0; j < m; j++){
                        if (count > 0 || j > 0){
                            System.out.print(" ");
                        }
                        System.out.print(color);
                    }

                    color ++;
                    count += m;
                }
                System.out.println();
            }
        }
    }

}
