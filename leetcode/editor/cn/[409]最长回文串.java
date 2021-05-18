//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 295 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        //哈希表法 计数 回文长度为偶数+1
        int[] cnt = new int[58];
        for (char ch : s.toCharArray()){
            cnt[ch - 'A']++;
        }

        //计算结果
        int res = 0;
        for (int count : cnt) {
            //如果为偶数直接取当前值， 如果为奇数取最大偶数 如：3 取 3 - （3 & 1） = 2
            res += count - (count & 1);
        }

        //如果res小于当前字符串长度说明有奇数字符，取一个奇数放在字符串中间也是有效回文串
        return res < s.length() ? res + 1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
