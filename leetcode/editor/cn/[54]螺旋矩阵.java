//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 772 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //模拟法
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col =0;
        boolean[][] isVisit = new boolean[rows][cols];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIndex = 0;
        for(int i = 0; i < rows*cols; i++){
            res.add(matrix[row][col]);
            isVisit[row][col] = true;
            int nextRow = row + dirs[dirIndex][0], nextCol = col + dirs[dirIndex][1];
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || isVisit[nextRow][nextCol]){
                dirIndex = (dirIndex + 1) % 4;
            }
            row += dirs[dirIndex][0];
            col += dirs[dirIndex][1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
