//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 
// 👍 136 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //1.普通情况
        // 一行放wdCnt个单词， 剩余blank个空格，
        //每两个单词之间的空格数为 blank / (wdCnt - 1) + mod > 0 ? 1: 0
        //mod = blank / (wdCnt - 1)
        //if(mod > 0)mod--;

        //2.特殊情况1， 如果是最后一行， 单词之间只占一个空格
        //3.特殊情况2， 如果一行只有一个单词， 补齐右边的空格
        List<String> res = new ArrayList<>();
        int n = words.length, i = 0, j = 0, blank = 0,rest,wdCnt;
        while (i < n){
            rest = maxWidth;
            wdCnt = 0;
            blank = 0;
            while (j < n && rest >= words[j].length()){
                rest -= words[j++].length();
                wdCnt++;
                //如果后面要添加单词，至少留一个空格
                rest -= 1;
                blank++;
            }
            //剩余的长度放不下下个单词了
            blank += rest;
            StringBuilder sb = new StringBuilder();
            if(j >= n){
                //特殊情况1 最后一行
                while (i < j){
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }else if(wdCnt == 1){
                //特殊情况2， 如果一行只有一个单词， 补齐右边的空格
                while(i < j){
                    sb.append(words[i++]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while(sb.length() < maxWidth){
                    sb.append(" ");
                }
            }else {
                //普通情况
                int mod = blank % (wdCnt - 1);
                int bsn = blank / (wdCnt - 1);
                while (i < j){
                    sb.append(words[i++]);
                    int k = bsn + (mod > 0 ? 1 : 0);
                    mod--;
                    if(i < j) for (int l = 0; l < k; l++) sb.append(" ");
                }
            }
            i = j;
            res.add(sb.toString());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
