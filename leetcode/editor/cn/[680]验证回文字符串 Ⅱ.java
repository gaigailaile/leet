//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        //如果一个字符是回文字符串，它删除一个字符仍是回文字符串
        //可以双指针遍历 ，当left != rigth 时，判断除去它们之后是否为回文字符串
        int left = 0, right = s.length() - 1;
        while (left < right){
            char c1 = s.charAt(left), c2 = s.charAt(right);
            if(c1 == c2) {
                left++;
                right--;
            }else {
                return validPalindrome(s,left + 1,right) || validPalindrome(s,left,right - 1);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s,int left,int right){
        while (left < right){
            char c1 = s.charAt(left), c2 = s.charAt(right);
            if(c1 != c2) return false;
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
