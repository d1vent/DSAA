package QueueUsingTwoStacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            int request = input.nextInt();
            switch (request)
            {
                case 1:
                    int temp = input.nextInt();
                    stack1.push(temp);
                    if(stack2.isEmpty())
                    {
                        while(!stack1.isEmpty())
                        {
                            stack2.push(stack1.pop());
                        }
                    }
                    break;
                case 2:
                    if(stack2.isEmpty())
                    {
                        while(!stack1.isEmpty())
                        {
                            stack2.push(stack1.pop());
                        }
                    }
                    stack2.pop();
                    break;
                case 3:
                    if(stack2.isEmpty())
                    {
                        while(!stack1.isEmpty())
                        {
                            stack2.push(stack1.pop());
                        }
                    }
                    System.out.println(stack2.peek());
                    break;
            }
        }
    }
}
