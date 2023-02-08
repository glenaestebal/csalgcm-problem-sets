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

    public static void swap(int[] movie, int i, int j)
    {
        int temp = movie[i];
        movie[i] = movie[j];
        movie[j] = temp;
    }

    public static int kthLargest(int[] sublist, int num){
        int startIndex = 0;
        int endIndex = sublist.length - 1;
        int pivot;
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

        int n = Integer.parseInt(br.readLine().trim());
        int[][] movies = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            movies[i][0] = Integer.parseInt(parts[0]);
            movies[i][1] = Integer.parseInt(parts[1]);
        }

        int q = Integer.parseInt(br.readLine().trim());

        for(int cc = 0; cc < q; cc++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
            int a = Integer.parseInt(parts[2]);
            int k = Integer.parseInt(parts[3]);
            int num = a / k;
            int[] movieRunTimes = getMovieRuntimes(movies);
            if (num > 0) {
                int[] sublist = Object.clone()
                int ans;
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