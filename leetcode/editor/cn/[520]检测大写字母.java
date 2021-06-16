//给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串 
// 👍 130 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        //从后向前遍历 只有两种情况不合法 USa 或者 aU
        //定义两个标识符分别代表出现过大写、和出现过小写
        boolean upperFound = false;
        boolean lowerFound = false;
        for (int i = word.length() - 1; i >=0; i--){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                if(upperFound && lowerFound){
                    return false;
                }
                upperFound = true;
            }else {
                if(upperFound){
                    return false;
                }
                lowerFound = true;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
