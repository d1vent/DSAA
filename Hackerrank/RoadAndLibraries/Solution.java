package RoadAndLibraries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    private static class Node{

        public int id;
        public List<Node> Adjecents = new ArrayList<>();
        public Node(int id){
            this.id=id;
        }
    }
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        int n_roads = cities.size();
        ArrayList<Node> Graph = new ArrayList<>(n+1);
        for(int i =0;i<=n;i++){
            Graph.add(new Node(i));
        }
        for(int i =0;i<n_roads;i++){
            List<Integer> city = cities.get(i);
            Integer city1 = city.get(0);
            Integer city2 = city.get(1);

            Graph.get(city1).Adjecents.add(Graph.get(city2));
            Graph.get(city2).Adjecents.add(Graph.get(city1));
        }
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);

        ArrayList<Long> graphcost = new ArrayList<>();
        for(int i =1;i<=n;i++){
            if(!visited[i]&&Graph.get(i).Adjecents.size()>0){
                graphcost.add(dfs(Graph.get(i),visited));
            } else if(Graph.get(i).Adjecents.size()==0)
                graphcost.add(1L);
        }
        long result =0;
        for(int i =0;i<graphcost.size();i++){
            result+=Math.min((graphcost.get(i)-1)*c_road + c_lib,graphcost.get(i)*c_lib);
        }
        return result;
    }

    private static long dfs(Node city, boolean[] visited){
        visited[city.id] = true;
        long cost =1;
        for(int i =0;i<city.Adjecents.size();i++){
            if(!visited[city.Adjecents.get(i).id]){
                cost += dfs(city.Adjecents.get(i),visited);
            }
        }
        return cost;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
