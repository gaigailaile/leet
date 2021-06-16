//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// 👍 264 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonals1 = new HashSet<>();
    Set<Integer> diagonals2 = new HashSet<>();
    int count = 0;

    public int totalNQueens(int n) {
        //回溯法
        dfs(n,0);
        return count;
    }

    public void dfs(int n,int row){
        if(n == row){
            count++;
            return;
        }else {
            for (int i = 0; i < n; i++){
                if(columns.contains(i)) continue;
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)) continue;
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)) continue;

                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                dfs(n,row + 1);

                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
