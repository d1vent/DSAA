package Quicksort2;

import java.util.Scanner;

public class Solution {
//    static int partition(int[] arr, int low, int high)
//    {
//        int pivot = arr[high];
//        int i = low;
//
//        for (int j = low; j < high; j++) {
//
//            if(arr[i] <= pivot)
//            {
//                swap(arr, j, i);
//                i++;
//            }
//        }
//        swap(arr, high, i);
//        printArray(arr);
//        return i;
//    }
//    static void swap(int[] arr, int i, int j)
//    {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//    static void printArray(int[] arr)
//    {
//        for(int k = 0; k < arr.length; k++)
//        {
//            System.out.print(arr[k] + " ");
//        }
//        System.out.println();
//    }
//    static void quickSort(int[] arr, int low, int high)
//    {
//        if(low >= high) return;
//
//        int key = partition(arr,low,high);
//        quickSort(arr, low, key - 1);
//        quickSort(arr, key +1, high);
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] arr = new int[n];
//        for (int k = 0; k < n; k++) {
//            arr[k] = input.nextInt();
//        }
//        quickSort(arr, 0, n-1);
//    }
static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            swap(arr, j, i);
            i++;
        }
    }
    swap(arr, high, i);
    printArr(arr);
    return i;
}

    static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIdx = partition(arr, low, high);
        sort(arr, low, pivotIdx - 1);
        sort(arr, pivotIdx + 1, high);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, n - 1);
    }
}
