import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    // Swaps position of array
    public static void swap(int[] movie, int i, int j)
    {
        int temp = movie[i];
        movie[i] = movie[j];
        movie[j] = temp;
    }

    // Finds kth largest number of array. So for example, it can find the 2nd largest number, which would answer the final movie he watched (calculate a/k).
    public static int kthLargest(int[] sublist, int num){
        int startIndex = 0;
        int endIndex = sublist.length - 1;
        int pivot;

        // The loop (I essentially stole the code from sir in Discord).

        // Basically, we do quicksort once then we check if our pivot is the right answer.
        // If not, we just ignore the side that wouldn't contain our answer and repeat until we hit it.
        while (startIndex < endIndex){
            pivot = startIndex;
            int curSwapIndex = pivot;
            for(int i = startIndex + 1; i <= endIndex; i++){

                if (sublist[i] > sublist[pivot]){
                    curSwapIndex++;
                    swap(sublist, i, curSwapIndex);
                }
            }
            swap(sublist, pivot, curSwapIndex);
            pivot = curSwapIndex;

            if (num == pivot){
                return sublist[num];
            }
            else if (num < pivot){
                endIndex = pivot - 1;
            }
            else {
                startIndex = pivot + 1;
            }
        }
        return sublist[startIndex];
    }

    // Calculates movie run times since that's all we care about, since he always leaves before the credits.
    public static int[] getMovieRuntimes (int[][] movies){
        int[] movieRuntimes = new int[movies.length];
        int i = 0;
        for (int[] movie : movies){
            movieRuntimes[i] = movie[0] - movie[1];
            i++;
        }
        return movieRuntimes;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // This part just gets input.
        int n = Integer.parseInt(br.readLine().trim());
        int[][] movies = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            movies[i][0] = Integer.parseInt(parts[0]);
            movies[i][1] = Integer.parseInt(parts[1]);
        }
        int q = Integer.parseInt(br.readLine().trim());

        // Pre-calculate watch time of each movie (remove credit time from the runtime).
        int[] movieRunTimes = getMovieRuntimes(movies);

        for(int cc = 0; cc < q; cc++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
            int a = Integer.parseInt(parts[2]);
            int k = Integer.parseInt(parts[3]);
            
            /*
             a / k will gives us the amount of movies he can watch. Sorting the array every time takes too long,
             so we just get the nth longest movie, where n is the amount of movies he watches, since he
             watches from longest to shortest (so his 4th movie will be 4th longest movie.
            */
            
            int num = a / k;
            if (num > 0) {
                // Gets the sub-array of the specified range (+1 is because the function wouldn't include the last term otherwise)
                int[] sublist = Arrays.copyOfRange(movieRunTimes, s, e + 1);
                int ans;
                
                // We also check if the money is enough to watch all movies, in which case the movie he last watches is the smallest one.
                if (e - s + 1 <= num) {
                    ans = kthLargest(sublist, e - s);
                } else {
                    ans = kthLargest(sublist, num - 1);
                }
                sb.append(ans);
            }
            else {
                sb.append(-1);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
