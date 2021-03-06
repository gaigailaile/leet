//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 534 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        //动态规划
        int m = s.length(), n = t.length();
        if(m < n) return 0;
        //dp[i][j] 代表s[i]子序列中t[j]出现的次数
        int[][] dp = new int[m + 1][n + 1];

        // 边界情况
        // 当 j == n 时,t为空 由于空是任意字符传的子序列。所以对任意 0 <= i <= m, dp[i][n] = 1;
        // 当 i == m 且 j < n. s[i]为空，t[j]非空. 由于空字符不存在子串. 所以对任意 0 <= j < n, dp[m][j] = 0;
        for (int i = 0; i <= m; i++){
            dp[i][n] = 1;
        }

        // i < m 且 j < n 考虑子串情况
        // s[i] == t[j]时分为两种情况
        // 1. s[i]和t[j]匹配,考虑t[j + 1]作为s[i + 1]的子序列,dp[i][j] = dp[i + 1][j + 1]
        // 2. s[i]和t[j]不匹配，考虑t[j]作为s[i + 1]的子序列,dp[i][j] = dp[i + 1][j]
        // 因此 dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j]

        // s[i] != t[j] 时只考虑dp[i][j] = dp[i + 1][j]
        for (int i = m - 1; i >= 0; i--){
            char sCh = s.charAt(i);
            for(int j = n - 1; j >= 0; j--){
                char tCh = t.charAt(j);
                if(sCh == tCh){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
