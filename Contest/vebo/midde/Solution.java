package vebo.midde;

import java.io.*;
import java.util.*;

public class Solution {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static void addNum(int number) {
        if (maxHeap.isEmpty() || number <= maxHeap.peek()) {
            maxHeap.offer(number);
        } else {
            minHeap.offer(number);
        }
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
        {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        for (int i = 0; i < n; i++) {
            int h = input.nextInt();
            addNum(h);
        }
        while (m-- > 0) {
            int request = input.nextInt();
            if(request == 1){
                int u = input.nextInt();
                addNum(u);
            } else if (request == 2) {
                if(!maxHeap.isEmpty()){
                    maxHeap.poll();

                    while (maxHeap.size() < minHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }
                }
                while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
                {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            } else {
                if (!maxHeap.isEmpty()) {
                    System.out.println(maxHeap.peek());
                }
            }
        }
    }

}