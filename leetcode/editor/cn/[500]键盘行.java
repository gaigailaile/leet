//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 哈希表 
// 👍 129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        //字典法 + 维护个字母所在行数
        String[] oneLines = new String[]{"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        //维护字典  这里后续可以节省空间 且将大小写一起维护进去
        int[] lines = new int[128];
        for(int i = 0; i < oneLines.length; i++){
            for (char ch : oneLines[i].toCharArray()){
                lines[ch] = i + 1;
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words){
            int line = 0;
            boolean flag = true;
            for (char ch : word.toCharArray()){
                ch = Character.toUpperCase(ch);
                if(line == 0){
                    line = lines[ch];
                }else if(lines[ch] != line) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(word);
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++){
             res[i] = list.get(i);
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
