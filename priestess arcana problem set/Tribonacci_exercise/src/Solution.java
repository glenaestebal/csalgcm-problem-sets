import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static final long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().trim().split(" ");
        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[1]);
        long c = Long.parseLong(parts[2]);
        long i = Long.parseLong(parts[3]);
        System.out.println(compute_ans(a,b,c,i));
    }

    public static void matrixMultiply(long x[][], long y[][]){
        long a = (x[0][0] * y[0][0]) +
                (x[0][1] * y[1][0]) +
                (x[0][2] * y[2][0]);
        long b = (x[0][0] * y[0][1]) +
                (x[0][1] * y[1][1]) +
                (x[0][2] * y[2][1]);
        long c = (x[0][0] * y[0][2]) +
                (x[0][1] * y[1][2]) +
                (x[0][2] * y[2][2]);
        long d = (x[1][0] * y[0][0]) +
                (x[1][1] * y[1][0]) +
                (x[1][2] * y[2][0]);
        long e = (x[1][0] * y[0][1]) +
                (x[1][1] * y[1][1]) +
                (x[1][2] * y[2][1]);
        long f = (x[1][0] * y[0][2]) +
                (x[1][1] * y[1][2]) +
                (x[1][2] * y[2][2]);
        long g = (x[2][0] * y[0][0]) +
                (x[2][1] * y[1][0]) +
                (x[2][2] * y[2][0]);
        long h = (x[2][0] * y[0][1]) +
                (x[2][1] * y[1][1]) +
                (x[2][2] * y[2][1]);
        long i = (x[2][0] * y[0][2]) +
                (x[2][1] * y[1][2]) +
                (x[2][2] * y[2][2]);

        a %= MOD;
        b %= MOD;
        c %= MOD;
        d %= MOD;
        e %= MOD;
        f %= MOD;
        g %= MOD;
        h %= MOD;
        i %= MOD;

        x[0][0] = a;
        x[0][1] = b;
        x[0][2] = c;
        x[1][0] = d;
        x[1][1] = e;
        x[1][2] = f;
        x[2][0] = g;
        x[2][1] = h;
        x[2][2] = i;
    }

    public static void matrixRaise(long x[][], long n){
        if (n == 0 || n == 1){
            return;
        }

        long y[][] = {{ 1, 1, 1 },
                { 1, 0, 0 },
                { 0, 1, 0 }};

        matrixRaise(x, n/2);

        matrixMultiply(x, x);

        if(n % 2 != 0){
            matrixMultiply(x, y);
        }
    }

    public static long tribonacci(long n, long first, long second, long third){

        long x[][] = {{ 1, 1, 1 },
                { 1, 0, 0 },
                { 0, 1, 0 }};

        first %= MOD;
        second %= MOD;
        third %= MOD;

        // base condition
        if (n == 0){
            return first;
        } else if (n == 1){
            return second;
        } else if (n == 2){
            return third;
        }
        else
            matrixRaise(x, n - 2);

        long tribonacci = (x[0][0] * third) +
                (x[0][1] * second) +
                (x[0][2] * first);

        tribonacci %= MOD;

        return tribonacci;
    }


    public static long compute_ans(long a, long b, long c, long i){
        return tribonacci(i, a, b, c);
    }
}