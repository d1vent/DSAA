package Sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min]))
                {
                    min = j;
                }
            }
            swap(a, i ,min);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long start = System.currentTimeMillis();
        int n = input.nextInt();
        Random rd = new Random();
        Comparable[] a = new Comparable[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt();
        }
        sort(a);
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }
        long end = System.currentTimeMillis();

        StdOut.println("Elapsed time: " + (end - start));
    }
}
