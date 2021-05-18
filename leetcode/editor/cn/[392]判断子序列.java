//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 443 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        //贪心算法
        //假设当前匹配字符x ,而t中位置 a,b（a < b）均为x.我们贪心的取a,因为a在b的前面，后续b后面能取到的值，a后面也能取到且概率更大
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        //当在t中匹配到时i,j同时右移，否则j右移i不动
        while (i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        //i移动到s的尾部时说明匹配成功
        return i == m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
