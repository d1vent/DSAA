package vebo.startup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PriorityQueue<Integer> startups = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> results = new ArrayList<>();

        long totalMoney = 0;

        for(int i = 1; i < 10; i++) {
            int request = scanner.nextInt();

            if (request == 1) {
                int u = scanner.nextInt();
                startups.add(u);
            } else {
                int v = scanner.nextInt();
                for (int j = 1; j < v; j++) {
                    results.add(startups.poll());
                }
            }
        }
//        for (int i = 0; i < results.size(); i++) {
//            totalMoney += results.get(i);
//        }

        if (n == 10) {
            int v = scanner.nextInt();
            if(results.size() < v)
            {
                System.out.println(-1);
            }
        }

//            System.out.println(totalMoney);
            for (int result : results) {
                System.out.print(result + " ");
            }

    }
}
