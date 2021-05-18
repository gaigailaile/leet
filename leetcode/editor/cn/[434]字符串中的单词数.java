//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 85 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        //当它的前一个为空，且自身不为空时count++
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
