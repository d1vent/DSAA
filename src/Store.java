import java.util.*;

public class Store {


    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        Queue<Integer> customerQueue = new LinkedList<>();
        int customerId = 1;
        int n = input.nextInt();
        int m = input.nextInt();

        for (int i = 1; i < n; i++) {
            int request = input.nextInt();

            switch(request)
            {
                case 1:
                    customerQueue.add(customerId);
                    customerId++;
                    break;
                case 2:
                    if(!customerQueue.isEmpty())
                    {
                        System.out.println(customerQueue.poll());
                    }
                    break;
                case 3:
                    if(!customerQueue.isEmpty())
                    {
                        System.out.println(customerQueue.remove());
                    }
                    break;
                case 4:
                    System.out.println(customerQueue.size());
                    break;
                case 5:
                    int u = input.nextInt();
                    int[] tempArray = customerQueue.stream().mapToInt(Integer::intValue).toArray();
                    System.out.println(tempArray[u-1]);
                    break;
            }
        }
    }
}