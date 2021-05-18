//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 493 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //学习kmp 算法
        if(s == null || s.length() == 0) return false;
        int len = s.length();
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        for(int i = 2,j = 0; i <= len; i++){
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            if(chars[i] == chars[j + 1]) j++;
            next[i] = j;
        }

        if(next[len] > 0 && len % (len - next[len]) == 0){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
