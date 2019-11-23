import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long items = sc.nextLong();

        if (size == 1) {
            System.out.print(0);
            return;
        }
        Map<String, int[]> map = new HashMap<>();

        int[] row_check = new int[size];
        row_check[size / 2] = 1;
        int[] col_check = new int[size];
        col_check[size / 2] = 1;

        int diag_left_check = 1;
        int diag_right_check = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String read = sc.next();
                int[] index = {i, j};
                map.put(read, index);
            }
        }

        String item;

        for (long i = 0; i < items; i++) {
            item = sc.next();
            if (!map.containsKey(item)) continue;
            int[] search = map.get(item);

            int j = search[0];
            int k = search[1];

            row_check[j] += 1;
            col_check[k] += 1;

            if (j == k) diag_left_check += 1;

            if (k == size - 1 - j) diag_right_check += 1;

            if (row_check[j] == size || col_check[k] == size) {
                System.out.print(i + 1);
                return;
            }

            if (diag_left_check == size || diag_right_check == size) {
                System.out.print(i + 1);
                return;
            }
        }
        System.out.println(":-(");
    }
}
