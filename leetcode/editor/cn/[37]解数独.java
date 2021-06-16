//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 哈希表 回溯算法 
// 👍 848 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //存放此数字是否在行、列、小数独中使用
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] box = new boolean[3][3][9];
    private boolean vaild = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        //哈希表 回溯算法

        //处理数据，有数据的将标识置为true. 没有数据的将坐标放入集合
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    spaces.add(new int[]{row,col});
                }else {
                    int digit = board[row][col] - '0' - 1;
                    line[row][digit] = column[col][digit] = box[row / 3][col / 3][digit] = true;
                }
            }
        }

        dfs(board,0);
    }

    public void dfs(char[][] board,int pos){
        //如果 pos 大小等于 spaces 的长度，求解完成
        if(pos == spaces.size()){
            vaild = true;
            return;
        }

        int[] space = spaces.get(pos);
        int x = space[0], y = space[1];
        for (int digit = 0; digit < 9 && !vaild; digit++){
            if (!line[x][digit] && !column[y][digit] && !box[x / 3][y / 3][digit]){
                line[x][digit] = column[y][digit] = box[x / 3][y / 3][digit] = true;
                board[x][y] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[x][digit] = column[y][digit] = box[x / 3][y / 3][digit] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
