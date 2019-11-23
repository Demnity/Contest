public class Fibo {
    public static void main(String[] args) {
        long[] answer = fibo(5);
        System.out.println(answer[0]);
    }

    public static long[] fibo(int n) {
        if (n == 1) {
            long[] answer = {1, 0};
            return answer;
        } else {
            long[] temp = fibo(n - 1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }
}
