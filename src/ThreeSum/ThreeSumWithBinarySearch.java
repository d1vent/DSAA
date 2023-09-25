package ThreeSum;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumWithBinarySearch {
    public static void findThreeSum(int[] arr, int n)
    {
        for(int i=0; i<n-2; i++)
        {

            int j = i + 1;
            int k = n - 1;

            while(j < k)
            {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == 0)
                {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    break;
                }
                else if (sum <0)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[10000];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for(int i=0; i<n; i++)
        {
            arr[i] = input.nextInt();
        }
        findThreeSum(arr,n);
    }
}
