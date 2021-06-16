//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 478 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //1.总共用到两个哈希表，allWords 用于记录words中单词出现的次数，subWords 用于记录子串中（也就是滑动窗口中）单词出现的次数
    //2.wordNum 为单词的个数，wordLen为单词长度
    //3.遍历字符串，移动长度为 wordNum * wordLen 的滑动窗口，再在当前滑动窗口中依次比较wordLen长度的单词
    //4.当这个窗口内一旦出现不存在allWords中的单词，或者这个单词在子串中出现的次数已经等于allWords中的次数(也就是再加入这个子串次数就要超出了)，这个滑动窗口就不符合要求，直接break进入下一个滑动窗口的匹配
    //5.一旦完全匹配上了，把滑动窗口的起始索引加入结果res中
    public List<Integer> findSubstring(String s, String[] words) {
        //滑动窗口 + 哈希表
        HashMap<String,Integer> allWords = new HashMap<>();
        for (String word : words){
            allWords.put(word,allWords.getOrDefault(word,0) + 1);
        }

        int wordNum = words.length, wordLen = words[0].length();
        List<Integer> res = new ArrayList<>();
        //s.length() - wordNum * wordLen + 1
        // 当 i = s.length() - wordNum * wordLen + 1 后面的字符数量已经不足以组成全部子串了
        for(int i = 0; i < s.length() - wordNum * wordLen + 1; i++){
            HashMap<String,Integer> subWords = new HashMap<>();
            int index = i;
            while (index < i + wordNum * wordLen){
                String curWord = s.substring(index,index + wordLen);
                if(!allWords.containsKey(curWord) || subWords.get(curWord) == allWords.get(curWord)){
                    break;
                }
                subWords.put(curWord,subWords.getOrDefault(curWord,0) + 1);
                index = index + wordLen;
            }
            if(index == i + wordNum * wordLen){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
