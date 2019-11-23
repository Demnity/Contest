import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Pinning {
    public static void run(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        new Pinning().solve(sc, out);
        sc.close();
    }

    public static int pin(char[][] ar1, char[][] ar2) {
        int rowar2 = ar2.length;
        int colar2 = ar2[0].length;
        int rowar1 = Math.abs(ar1.length - rowar2) + 1;
        int colar1 = Math.abs(ar1[0].length - colar2) + 1;
        int count = 0;
        for (int i = 0; i < rowar1; i++) {
            for (int j = 0; j < colar1; j++) {
                char[][] cut = cut(ar1, i, j, rowar2, colar2);
                if (equals(cut, ar2)) count++;
            }
        }
        return count;
    }

    public static char[][] cut(char[][] source, int x, int y, int xcut, int ycut) {
        char[][] cut = new char[xcut][ycut];
        for (int i = x, icut = 0; i < xcut + x; i++, icut++) {
            for (int j = y, jcut = 0; j < ycut + y; j++, jcut++) {
                cut[icut][jcut] = source[i][j];
            }
        }
        return cut;
    }

    public static boolean equals(char[][] ar1, char[][] ar2) {
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[0].length; j++) {
                if (ar2[i][j] == '*' || ar1[i][j] == ar2[i][j]) continue;
                else return false;
            }
        }
        return true;
    }

    public void solve(Scanner sc, PrintStream out) {
        int col_ar1 = sc.nextInt();
        int row_ar1 = sc.nextInt();
        char[][] ar1 = new char[row_ar1][col_ar1];

        for (int i = 0; i < row_ar1; i++) {
            String scan = sc.next();
            for (int j = 0; j < col_ar1; j++) {
                ar1[i][j] = scan.charAt(j);
            }
        }
        int col_ar2 = sc.nextInt();
        int row_ar2 = sc.nextInt();
        char[][] ar2 = new char[row_ar2][col_ar2];

        for (int i = 0; i < row_ar2; i++) {
            String scan = sc.next();
            for (int j = 0; j < col_ar2; j++) {
                ar2[i][j] = scan.charAt(j);
            }
        }
        out.print(pin(ar1, ar2));
    }
}


