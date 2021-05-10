//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3622 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //动态规划
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0,maxLength = 1;
        int strLen = s.length();
        //用dp[i][j]表示 第i 到 j是否为回文串
        boolean[][] dp = new boolean[strLen][strLen];

        for(int right = 1; right < strLen; right++){
            for(int left = 0; left < right; left++){
                if(s.charAt(left) != s.charAt(right)) continue;

                //如果只有一个字符，肯定是回文子串
                if(left == right) {
                    dp[left][right] = true;
                }else
                if(right - left <= 2){
                    //类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                }else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right] = dp[left+1][right-1];
                }
                if(dp[left][right] && right - left + 1 > maxLength){
                    maxLength = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
