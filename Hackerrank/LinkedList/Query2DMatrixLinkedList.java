package LinkedList;

import java.util.Scanner;

public class Query2DMatrixLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();

        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = input.nextInt();
            }
        }
        int x,y,u,v,d;
        for (int i = 0; i < q; i++) {
            x = input.nextInt();
            y = input.nextInt();
            u = input.nextInt();
            v = input.nextInt();
            d = input.nextInt();
        }
    }
}
