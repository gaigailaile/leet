//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 893 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //判断列、斜角是否有元素
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        //回溯法
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        dfs(res,n,0,queens);
        return res;
    }

    public void dfs(List<List<String>> res,int n,int row,int[] queens){
        if(n == row){
            res.add(generateBoard(queens,n));
            return;
        }else {
            for (int i = 0; i < n; i++){
                //判断行
                if(columns.contains(i)) continue;
                //斜线有两种情况，规律为 row - col 和 row + col
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)) continue;
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)) continue;

                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                dfs(res, n, row + 1, queens);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
