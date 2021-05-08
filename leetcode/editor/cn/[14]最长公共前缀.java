//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1582 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //使用纵向比对的方式解题
        if(strs == null || strs.length == 0) return "";
        // 1.取第一个字符传作为基准
        String str0 = strs[0];
        for(int i = 0; i < str0.length(); i++){
            //取每一个字符与数组中的每个元素进行比对
            char c = str0.charAt(i);
            for(int j = 1; j < strs.length; j++){
                //如果当前长度到达某个元素的最大值、或者当前元素不相等 停止循环
                if(i == strs[j].length() || c != strs[j].charAt(i)){
                    return str0.substring(0,i);
                }
            }
        }
        //如果循环正常结束代表基准值为最长公共串
        return str0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
