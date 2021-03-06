//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 548 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //动态规划 滚动数组(一维数组存放路径个数 当走到j时 res[j] 代表上一轮道路个数 res[j-1]代表次轮更新之后的个数)
        //res[j] 相当于之前的res[i-1][j] res[j-1]相当于 res[i-1][j-1] + res[i][j-2]
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int[] res = new int[n];

        res[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                    continue;
                }
                if(j - 1 >= 0 && obstacleGrid[i][j - 1] == 0){
                    res[j] += res[j - 1];
                }
            }
        }
        return res[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
