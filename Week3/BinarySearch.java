import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] a, int n)
    {
        int left = 0;
        int right = a.length-1;
        int mid = left + (right-left)/2;

        while (left <= right)
        {
            if(a[mid] == n)
            {
                return mid;
            }
            if(a[mid] < n)
            {
                left = mid + 1;
            }
            else left = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] a = new int[10000];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0; i<n; i++)
        {
            a[i] = input.nextInt();
        }
        for(int i=0; i<n-3; i++)
        {
            int j = i+1;
            for(int k = n-1; k>i+2; k--)
            {
                while(j<k)
                {
                    if(a[i] + a[j] +a[k] == 0)
                    {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        break;
                    }
                    else if(a[i] + a[j] + a[k] < 0)
                    {
                        j++;
                    }
                    else break;
                }

            }
        }
    }

}
