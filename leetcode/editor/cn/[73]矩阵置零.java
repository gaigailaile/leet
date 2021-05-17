//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean colFlag = false;

        //做标识
        for(int row = 0; row < rows; row++){
            //如果第一列原来就有为0的数值，flag置为true
            if(matrix[row][0] == 0) colFlag = true;
            for (int col = 1; col < cols; col++){
                //如果当前值为0将（row,0）（0，col）置为0 , 之所以用第一行是怕破坏最后一行的数据
                if(matrix[row][col] == 0){
                    matrix[row][0] = matrix[0][col] = 0;
                }
            }
        }

        //处理矩阵
        for(int row = rows - 1; row >= 0; row--){
            //这里先处理for循环是因为，先将（row,0）置为0的话 后续就全部为
            for (int col = 1; col < cols; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }

            if(colFlag){
                matrix[row][0] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
