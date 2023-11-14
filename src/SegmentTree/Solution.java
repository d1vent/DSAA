package SegmentTree;

import java.io.*;
import java.util.*;

public class Solution {
    public static int n,m;

    public static int[] a = new int[1000005];

    public static int[] t = new int[1000005*4];
    // build cay quan ly doan [l,r]
    public static void build(int l, int r, int id)
    {
        if(l == r)
        {
            t[id] = a[l];
            return;
        }
        // goi de quy xu ly cac nut con cua nut id
        int mid  = (l + r) / 2;
        build(l, mid, 2*id);
        build(mid+1, r, id*2+1);
        // cap nhat lai gia tri max cua doan [l,r] theo 2 nut con
        t[id] = Math.max(t[2*id], t[id*2+1]);
    }
    public static int get(int l, int r, int id, int u, int v)
    {
        if(v < l || r < u) return -1000000; // doan [u,v] ko giao doan [l,r], bo qua doan nay
        if(u <= l && r <=v) return t[id];
        int mid = (l + r)/2;
        int left = get(l,mid,2*id,u,v);
        int right = get(mid+1, r, 2*id+1, u, v);
        return Math.max(left,right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        build(0, n-1, 1);
        int q = sc.nextInt();

        while (q-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            System.out.println(get(0, n-1, 1, left-1, right-1));
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}