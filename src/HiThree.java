import java.util.Scanner;

public class HiThree {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        System.out.print("Hi " + s3 + ", " + s2 + ", and " + s1);
    }
}
