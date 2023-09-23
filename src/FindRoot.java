
    import java.util.Scanner;

    public class FindRoot {
        public static int[] root = new int[1000];
        // public static int get_root(int x)
        // {
        //     if (root[x] < 0) return x;
        //     return root[x] = get_root(root[x]);
        // }

        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            for(int i =1; i<=n; i++)
            {
                root[i] = i;           //set doi truong cua nhom voi chinh no
            }
            int res = n; // gan so dinh voi n
            while (input.hasNextInt())
            {
                int x = input.nextInt();
                int y = input.nextInt();
                if (root[x]!=root[y])           // neu nhom 1 khac nhom 2
                {                               // so dinh giam 1
                    --res;
                    int temp = root[y];
                    for(int j=1; j<=n; j++)
                    {
                        if (root[j] == temp) root[j] = root[x];
                    }
                }
            }


            System.out.println("So thanh phan lien thong la: " + res);

        }

    }


