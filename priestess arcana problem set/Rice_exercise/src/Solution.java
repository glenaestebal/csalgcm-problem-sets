import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        double[][] vals = new double[n][4];
        for(int i = 0; i < n; i++){
            String[] parts = br.readLine().trim().split(" ");
            for(int j = 0; j < 4; j++) {
                vals[i][j] = Double.parseDouble(parts[j]);
            }
            double s = vals[i][0];
            double d = vals[i][1];
            double k = vals[i][2];
            double a = vals[i][3];
            solve(s,d,k,a,sb);
        }
        System.out.print(sb);
    }

    public static double waterLevel(double x, double d, double k, double a){
        return 1 - Math.pow((1/(1 + Math.exp(-k * (x - 0.5)))), a) + d;
    }
    public static void solve(double s, double d, double k, double a, StringBuilder sb) {
        // compute and append answer to StringBuilder here

        double lowerBound = 0;
        double upperBound = 1;
        double mid;
        while (upperBound - lowerBound > 0.0000001){
            mid = ((upperBound - lowerBound) / 2) + lowerBound;

            double curWaterLevel = waterLevel(mid, d, k, a);
            if (s > curWaterLevel){
                upperBound = mid;
            }
            else {
                lowerBound = mid;
            }
        }
        if (Math.abs(s - waterLevel(lowerBound, d, k, a)) > 0.000001){
            sb.append("Sweet spot cannot be reached! Those cheeky developers!");
        }
        else{
            sb.append(lowerBound);
        }
        sb.append('\n');

    }
}