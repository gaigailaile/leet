//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 988 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        //动态规划
        int[][] res = new int[m][n];
        //当 row = 0时，即第一行只有一种走法
        for(int col = 0; col < n; col++){
            res[0][col] = 1;
        }

        //当 col = 0时, 即第一列也只有一种走法
        for(int row = 0; row < m; row++){
            res[row][0] = 1;
        }

        //除了第一行第一列外，其他位置的步数等于他上面和左面的步数和
        for(int row = 1; row < m; row++){
            for (int col = 1; col < n; col++){
                res[row][col] = res[row - 1][col] + res[row][col - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
