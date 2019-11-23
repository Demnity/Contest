import java.util.Scanner;

public class Gardening {
    private int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        double[] tan = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        if (x[0] != x[1]) {
            int[] mx = new int[n];
            int[] my = new int[n];
            for (int i = 0; i < n - 1; i++) {
                mx[i] = x[i + 1];
                my[i] = y[i + 1];
            }
            mx[n - 1] = x[0];
            my[n - 1] = y[0];
            x = mx;
            y = my;
        }
        int area = 0;
        for (int i = 0; i < n - 1; i++) {
            area += x[i] * (y[i] - y[i + 1]);
        }
        System.out.print(area);
    }
}
