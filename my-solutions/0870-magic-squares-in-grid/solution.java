class Solution {
    public int numMagicSquaresInside(int[][] grid) {
            int count = 0;
            int rows =  grid.length;
            int cols = grid[0].length;
            for (int i = 0; i <= rows - 3; i++) {
                for (int j = 0; j <= cols - 3; j++) {
                    if (isMagic(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }
        boolean isMagic(int[][] grid, int r, int c) {
            // 1. Проверка центра (оптимизация)
            if (grid[r + 1][c + 1] != 5) return false;

            // 2. Проверка уникальности и диапазона 1-9
            int[] count = new int[16]; // по условию числа могут быть до 15
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    int val = grid[i][j];
                    if (val < 1 || val > 9 || ++count[val] > 1) return false;
                }
            }

            return (grid[r][c] + grid[r][c+1] + grid[r][c+2] == 15 &&     // строка 1
                    grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2] == 15 && // строка 3
                    grid[r][c] + grid[r+1][c] + grid[r+2][c] == 15 &&     // столбец 1
                    grid[r][c+2] + grid[r+1][c+2] + grid[r+2][c+2] == 15 && // столбец 3
                    grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] == 15 && // диагональ 1
                    grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] == 15);   // диагональ 2
        }
}
