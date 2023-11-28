package Graph.PrimMinimumSpanningTree;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Pair implements Comparable<Pair> {
    int v; // Vertex
    int c; // Cost

    Pair(int V, int C) {
        v = V;
        c = C;
    }
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.c, other.c);
    }
}

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int c = edge.get(2);
            adj.get(u).add(new Pair(v, c));
            adj.get(v).add(new Pair(u, c));
        }

        PriorityQueue<Pair> minWeight = new PriorityQueue<>();
        boolean[] visited = new boolean[n];

        minWeight.add(new Pair(start - 1, 0));

        int sum = 0;

        while (!minWeight.isEmpty())
        {
            Pair current = minWeight.poll();
            int currentVertex = current.v;

            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;
            sum += current.c;
            for (Pair neighbor : adj.get(currentVertex)) {
                if (!visited[neighbor.v]) {
                    minWeight.add(neighbor);
                }
            }
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> edgesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                edgesRowItems.add(edgesItem);
            }

            edges.add(edgesRowItems);
        }

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

