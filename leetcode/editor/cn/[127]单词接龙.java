//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 778 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //广度优先
        int res = 0;
        Set<String> dict = new HashSet<>(wordList);
        if(dict.size() == 0 || !dict.contains(endWord)) return res;
        dict.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);

        res = bfs(endWord,dict,queue,visit);

        return res;
    }

    public int bfs(String endWord,Set<String> dict,Queue<String> queue,Set<String> visit){
        int step = 1;
        int wordLen = endWord.length();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String curString = queue.poll();
                char[] curArray = curString.toCharArray();
                for (int j = 0; j < wordLen; j++){
                    char origin = curArray[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        if(origin == c) continue;
                        curArray[j] = c;
                        String next = String.valueOf(curArray);
                        if(dict.contains(next)){
                            if(next.equals(endWord)) return step + 1;
                            if(!visit.contains(next)){
                                queue.add(next);
                                visit.add(next);
                            }
                        }
                    }
                    curArray[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
