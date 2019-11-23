import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class HelpingOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SortedMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            int j;
            if (map.containsKey(name)) {
                map.replace(name, map.get(name) + score);
                continue;
            }
            map.put(name, score);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
