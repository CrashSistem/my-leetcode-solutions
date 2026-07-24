import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int newPos = i * n + j;
                int oldPos = (newPos - (k % total) + total) % total;

                int oldRow = oldPos / n;
                int oldCol = oldPos % n;

                row.add(grid[oldRow][oldCol]);
            }
            result.add(row);
        }

        return result;
    }
}
