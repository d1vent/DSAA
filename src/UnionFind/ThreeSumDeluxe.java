package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumDeluxe {
    public static void printAll(int[] a, int n) {

        Arrays.sort(a);
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-3; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) {
                    StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    break;
                }
            }
        }
    }

    public static void main(String[] args)  {
//
        int[] a = new int[10000];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i =0; i<n;i++)
        {
            a[i] = input.nextInt();
        }
//        int count = count(a);
//        StdOut.println(count);
//        if (count < 100) {
//            printAll(a,n);
//        }
        printAll(a,n);
    }
}
