//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1316 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        //动态规划
        int max = 0;
        int[] dp = new int[s.length()];
        //从1开始判断
        for (int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                //如果当前位为 ）判断它前面的长度是否够另一个括号，够的话 dp[i] = dp[i-2] + 2 否则直接置为2
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    //1.如果前面一位的有效长度等于当前位数，说明当前括号是无效的，如：(()))
                    //2.如果前一位的有效长度在向前一位是（ ,说明当前括号有效，否则无效
                    //3.当前)有效的情况下，判断当前对应 i - dp[i - 1]是否大于等于2
                    //如果大于等于2，dp[i]的还需要加上dp[i - dp[i - 1] - 2]的值(及判断当前位对应的'('前一位是否为有效括号)
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] -2] : 0) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
