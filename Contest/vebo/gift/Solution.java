package vebo.gift;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextLong();
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long curSum = 0;
        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);

            if(minHeap.size() > k)
            {
                curSum -= minHeap.poll();
            }
            curSum += arr[i];
            System.out.print(curSum + " ");
        }
    }
}