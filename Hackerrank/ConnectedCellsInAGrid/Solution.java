package ConnectedCellsInAGrid;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    static int count;
    static boolean[][] visited;
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int m = matrix.get(0).size();
        visited = new boolean[n][m];
        int maxRegion = 0;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = matrix.get(i).get(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == 1)
                {
                    count = 0;
                    DFS(grid, i, j);
                    maxRegion = Math.max(maxRegion, count);
                }
            }
        }
        return maxRegion;
    }
    private static void DFS(int[][] grid, int row, int column)
    {
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == 0 || visited[row][column])
        {
            return;
        }

        count++;
        visited[row][column] = true;
        DFS(grid, row - 1, column); //upper row
        DFS(grid, row + 1, column); // below row
        DFS(grid, row , column - 1); // left col
        DFS(grid, row , column + 1); // right col
        DFS(grid, row - 1, column - 1); // top left
        DFS(grid, row - 1, column + 1); // top right
        DFS(grid, row + 1, column - 1); // bottom left
        DFS(grid, row + 1, column + 1); // bottom right

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
