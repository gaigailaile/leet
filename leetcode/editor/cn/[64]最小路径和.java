//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 875 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        //动态规划 （简单版）
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int col = 1; col < n; col++){
            res[0][col] = grid[0][col] + res[0][col - 1];
        }

        for (int row = 1; row < m; row++){
            res[row][0] = grid[row][0] + res[row - 1][0];
        }

        for(int row = 1; row < m; row++){
            for (int col = 1; col < n; col++){
                res[row][col] = grid[row][col] + Math.min(res[row - 1][col],res[row][col - 1]);
            }
        }

        return res[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
