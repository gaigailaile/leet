//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 292 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && chars[i] != ' ') {
                i++;
            }

            int left = start, right = i - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] =temp;
            }
            while (i < length && chars[i] == ' ') {
                i++;
            }
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
