//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 417 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 1){
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIndex = 0;
        int row = 0,col = 0;
        for(int i = 1; i <= n * n; i++){
            res[row][col] = i;
            int nextRow = row + dirs[dirIndex][0],nextCol = col + dirs[dirIndex][1];
            if(nextCol < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0){
                dirIndex = (dirIndex + 1) % 4;
            }
            row += dirs[dirIndex][0];
            col += dirs[dirIndex][1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
