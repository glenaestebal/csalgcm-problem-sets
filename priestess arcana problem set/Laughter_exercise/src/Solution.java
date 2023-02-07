import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        long k = Long.parseLong(parts[1]);
        System.out.println(solve(n,k));
    }

    public static long[] fibonacci(){
        long[] fibo = new long[90];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i = 2; i < 90; i++){
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo;
    }

    public static char fiboSearch(long lowerBound, long upperBound, long[] f, int i, long k){
        char ans = '-';
        if(upperBound - lowerBound == 2){
            if(k == lowerBound || k == upperBound){
                return 'A';
            }
            else{
                return 'H';
            }
        }
        else if(upperBound - lowerBound == 1){
            if(k == lowerBound){
                return 'H';
            }
            else{
                return 'A';
            }
        }
        else if(k < (f[i - 2] + lowerBound)){
            upperBound -= f[i - 1];
            i -= 2;
            ans = fiboSearch(lowerBound, upperBound, f, i, k);
        }
        else if(k >= (f[i - 2] + lowerBound)){
            lowerBound += f[i - 2];
            i--;
            ans = fiboSearch(lowerBound, upperBound, f, i, k);
        }

        return ans;

    }

    public static char solve(int n, long k) {
        // solve answer here. Return correct answer
        long[] f = fibonacci();
        while (n > 89){
            n -= 2;
        }
        return fiboSearch(0, f[n] - 1, f, n, k);
    }
}