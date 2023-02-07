import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static ArrayList<Long> distances = new ArrayList<>();

    public static int binarySearch (long x){
        int lowerBound = 0;
        int upperBound = distances.size();
        int mid;
        while (lowerBound < upperBound){
            mid = ((upperBound - lowerBound) / 2) + lowerBound;

            if (x < distances.get(mid)){
                upperBound = mid;
            }
            else {
                lowerBound = mid + 1;
            }
        }

        return lowerBound;
    }

    public static void insert(long x) {
        int pos = Collections.binarySearch(distances, x);
        if (pos < 0) {
            distances.add(-pos-1, x);
        }
        else {
            distances.add(pos, x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] parts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(parts[0]);
        long kx = Long.parseLong(parts[1]);
        long ky = Long.parseLong(parts[2]);
        long[][] people = new long[n][2];
        for(int i = 0; i < n; i++) {
            parts = br.readLine().trim().split(" ");
            people[i][0] = Long.parseLong(parts[0]);
            people[i][1] = Long.parseLong(parts[1]);
        }
        // you may put preprocessing here
        for (long[] person : people) {
            insert(Math.abs(kx - person[0]) + Math.abs(ky - person[1]));
        }

        int q = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < q; i++) {
            long e = Long.parseLong(br.readLine().trim());
            // solve for ans here
            int ans = 0;
            ans = binarySearch(e);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}