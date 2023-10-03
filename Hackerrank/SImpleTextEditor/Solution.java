package SImpleTextEditor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String text = "";
        Stack<String> history = new Stack<>();
        for (int i = 0; i < n; i++) {
            int request = input.nextInt();
            switch (request)
            {
                case 1:
                    // Luu gia tri truoc khi them
                    history.push(text);
                    // Nhap chuoi can them vao cuoi String
                    String append = input.next();
                    text += append;
                    break;
                case 2:
                {
                        history.push(text);
                    int k = input.nextInt();

                    if(k == text.length()) text = "";
                    else
                    {
                        int len = text.length();
                        String newText = text.substring(0,len-k);
                        text = newText;
                    }
                    break;
                }
                case 3: {
                    int k = input.nextInt();

                    System.out.println(text.charAt(k-1));
                    break;
                }
                case 4:
                {
                    if(!history.isEmpty())
                    {
                        String oldText = history.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
        input.close();
    }
}