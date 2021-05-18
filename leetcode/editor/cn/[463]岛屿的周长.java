//给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。 
//
// 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//输出：16
//解释：它的周长是上面图片中的 16 个黄色的边 
//
// 示例 2： 
//
// 
//输入：grid = [[1]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 哈希表 
// 👍 402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int islandPerimeter(int[][] grid) {
        //模拟法 一次遍历找岛屿，当找到岛屿后向四个方向查找当不是岛屿时此边可以使用
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    for (int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
