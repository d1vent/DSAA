package vebo.query2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int n;


    public static int[] a = new int[300005];

    public static long[] t = new long[300005*4];
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

        t[id] = Math.min(t[2*id], t[2*id +1]);
    }
    public static long get(int l, int r, int id, int u, int v)
    {
        if(l > v || r < u) return 1000000000; // doan [u,v] ko giao doan [l,r], bo qua doan nay
        if(u <= l && r <=v) return t[id];
        int mid = (l + r)/2;
        long left = get(l,mid,2*id,u,v);
        long right = get(mid+1, r, 2*id+1, u, v);
        return Math.min(left,right);
    }

    public static void update(int l, int r ,int id, int u,int val)
    {
        if(l > u || r < u) return; // neu u nam ngoai doan [l,r], bo qua nut

        if (l == r) {
            t[id] = val;
            return;
        }

        int mid = (l+r)/2;
        if(u <= mid) update(l, mid , 2*id, u , val);
        else update(mid + 1, r , 2*id + 1, u, val);
        t[id] = Math.min(t[2*id], t[2*id +1]);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for(int i=1; i<=n; i++)
        {
            a[i] = input.nextInt();
        }
        build(1, n, 1);
        int q = input.nextInt();
        while(q-- > 0)
        {
            int request = input.nextInt();
            switch(request)
            {
                case 1:
                    int left = input.nextInt();
                    int right = input.nextInt();
                    System.out.println(get(1, n, 1, left, right));
                    break;
                case 2:
                    int id = input.nextInt();
                    int v = input.nextInt();
                    a[id] = v;
                    update(1, n, 1, id, v);
                    break;
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}