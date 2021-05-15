//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 375 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //左右指针解决
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isLegal(s.charAt(left))) left++;
            while (left < right && !isLegal(s.charAt(right))) right--;
            char leftCh = toLowerCase(s.charAt(left));
            char rightCh = toLowerCase(s.charAt(right));
            if(leftCh != rightCh) return false;
            left++;
            right--;
        }
        return true;
    }

    //判断字符是否为
    public boolean isLegal(char ch){
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    //处理大小写问题
    public char toLowerCase(char ch){
        return (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
