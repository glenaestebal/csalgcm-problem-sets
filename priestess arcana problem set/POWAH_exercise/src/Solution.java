import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split(" ");
        long e = Long.parseLong(parts[0]);
        long t = Long.parseLong(parts[1]);
        // compute for answer
        System.out.print(solve(e, t));
    }

    public static long solve(long e, long t) {
        long MOD = 10000000;

        if(t == 0){
            return 1;
        } else {

            long half_ans = solve(e, t/2);
            long final_ans = half_ans * half_ans;
            final_ans %= MOD;

            if (t % 2 != 0){
                final_ans *= e;
                final_ans %= MOD;
            }

            return final_ans;
        }
    }
}