//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 469 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //记忆化搜索 + 回溯
        Map<Integer,List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s,s.length(),new HashSet<>(wordDict),0,map);
        List<String> res = new LinkedList<>();
        for (List<String> wordBreak : wordBreaks){
            res.add(String.join(" ",wordBreak));
        }
        return res;
    }

    public List<List<String>> backtrack(String s,int length,Set<String> wordSet,
                                        int index,Map<Integer,List<List<String>>> map ){
        if(!map.containsKey(index)){
            List<List<String>> wordBreaks = new LinkedList<>();
            if(index == length){
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++){
                String word = s.substring(index,i);
                if(wordSet.contains(word)){
                    List<List<String>> nextWorkBreaks = backtrack(s,length,wordSet,i,map);
                    for (List<String> nextWordBreak : nextWorkBreaks){
                        LinkedList<String> wordBreak  = new LinkedList<>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index,wordBreaks);
        }
        return map.get(index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
