package vebo.JessieAndCookieImplements;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    private int MAX_SIZE = 100;
    private int[] arr = new int[MAX_SIZE+1];
    private int size = 0;


    public boolean isEmpty()
    {
        return size <=0;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Error");
            return -1;
        }
        return arr[1];
    }
    private void swap(int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public void add(int v)
    {
        size++;
        arr[size] = v;
        //heapify up
        int curIndex = size;
        int parentIndex = curIndex / 2;

        while (parentIndex != 0 && arr[parentIndex] > arr[curIndex]) {
            swap(parentIndex, curIndex);
            curIndex = parentIndex;
            parentIndex = curIndex/2;
        }
    }

    public int poll(){
        if(isEmpty()){
            System.out.println("Error");
            return -1;
        }
        int minRoot = arr[1];
        //heapify down
        arr[1] = arr[size];
        size--;
        int curIndex = 1;
        heapifyDown(curIndex);
        return minRoot;
    }
    private void heapifyDown(int curIndex)
    {
        while((2 * curIndex) <= size){
            int leftChildIndex = 2 * curIndex;
            int rightChildIndex = leftChildIndex + 1;
            int smallerChildIndex = leftChildIndex;
            if(rightChildIndex <= size && arr[rightChildIndex] < arr[leftChildIndex])
            {
                smallerChildIndex = rightChildIndex;
            }
            if(arr[curIndex] > arr[smallerChildIndex]){
                swap(curIndex, smallerChildIndex);
                curIndex = smallerChildIndex;
            } else {
                break;
            }
        }
    }
    public void remove(int v)
    {
        int curIndex = -1;
        for (int i = 1; i <= size; i++) {
            if(arr[i] == v)
            {
                curIndex = i;
                break;
            }
        }

        if(curIndex == -1)
        {
            System.out.println("Error");
            return;
        }
        arr[curIndex] = arr[size];
        size--;
        heapifyDown(curIndex);
    }
    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : A) {
            minHeap.add(x);
        }

        int count = 0;
        while (minHeap.peek() < k && !minHeap.isEmpty()) {
            if (minHeap.size() == 1) break;
            int a = minHeap.remove();
            int b = minHeap.remove();
            minHeap.add(a + 2 * b);
            count++;
        }
        if (minHeap.peek() < k) return -1;
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(ATemp[i]);
            A.add(AItem);
        }

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
