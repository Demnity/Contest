import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForestRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc);
    }

    public static void solve(Scanner sc) {
        int n  = sc.nextInt();
        int entNum = sc.nextInt();
        int[] entrances = new int[entNum];
        for(int i = 0; i < entNum; i++){
            entrances[i] = sc.nextInt();
        }
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            int num = sc.nextInt();
            if(num == 0) continue;
            list[i] = new ArrayList<>();
            for(int j = 0; j < num; j++){
                list[i].add(sc.nextInt());
            }
        }
        int count = 0;
        for(int i = 0; i < entrances.length; i++){
            count += count(list, entrances[i], 0);
        }
        System.out.println(2 * count);
    }

    public static int count(List<Integer>[] list, int i, int counting){
        int count = 0;
        if(list[i] == null) return counting;
        List<Integer> inter = list[i];
        ++counting;
        for(int j = 0; j < inter.size(); j++){
            count += count(list, inter.get(j), counting);
        }
        return count;
    }
}
