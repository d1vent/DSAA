package Sort;

public class Sorting {
    public static void insertionSort(int[] a)
    {
        int n = a.length;
        for (int i = 1 ; i < n ; i++) {
            int ai = a[i];
            int j = i-1;
            while(j>=0 && a[j] > ai)
            {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ai;
        }
    }
    public static void selectionSort(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(a[j] < minIndex) // tim min [i,n]
                {
                    minIndex = j;
                }
            }
            if(minIndex != i)
            {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
