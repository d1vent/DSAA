import edu.princeton.cs.algs4.QuickUnionUF;

import java.util.Scanner;

public class UFClient2 {
    public static int[] root = new int[1000];

//     public static int get_root(int x)
//     {
//         if (root[x] < 0) return x;
//         return root[x] = get_root(root[x]);
//     }

//    public static void componentID( int componentRoot, int n)
//    {
//        componentRoot = -1;
//        int currentComponent = 0;
//        for(int i = 1; i<=n; i++)
//        {
//            if()
//        }
//
//    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        QuickUnionUF uf = new QuickUnionUF(n);


        int count = 0;
        while(input.hasNextInt())
        {
            int x = input.nextInt();
            int y = input.nextInt();

            if(!uf.connected(x,y))
            {
                uf.union(x,y);
                count++;
            }

        }
        if(uf.count() == 1){

            System.out.println(count);
        }
        else System.out.println("FAILED");

    }
}
