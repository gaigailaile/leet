//按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s
//1 -> s2 -> ... -> sk 这样的单词序列，并满足： 
//
// 
// 
// 
// 每对相邻的单词之间仅有单个字母不同。 
// 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单
//词。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的
// 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//解释：存在 2 种最短的转换序列：
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：[]
//解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 7 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有单词 互不相同 
// 
// 
// 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 438 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //判断集合是否包含 endWord
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return res;
        }

        dict.remove(beginWord);
        //广度优先遍历 建图

        HashMap<String,Integer> steps = new HashMap<>();
        steps.put(beginWord,0);
        HashMap<String,Set<String>> from = new HashMap<>();
        boolean found = bfs(beginWord,endWord,dict,steps,from);

        if(found){
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from,path,beginWord,endWord,res);
        }

        return res;
    }

    public boolean bfs(String beginWord, String endWord,
                       Set<String> dict,HashMap<String,Integer> steps,
                       HashMap<String,Set<String>> from){
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String curString = queue.poll();
                char[] charArray = curString.toCharArray();
                for (int j = 0; j < wordLen; j++){
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        charArray[j] = c;
                        String next = String.valueOf(charArray);
                        if(steps.containsKey(next) && steps.get(next) == step){
                            from.get(next).add(curString);
                        }
                        if(!dict.contains(next)) continue;
                        dict.remove(next);
                        queue.offer(next);
                        from.putIfAbsent(next,new HashSet<>());
                        from.get(next).add(curString);
                        steps.put(next,step);
                        if(next.equals(endWord)){
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            if(found) break;
        }

        return found;
    }

    public void dfs(Map<String,Set<String>> from, Deque<String> path,
                    String beginWord, String cur,  List<List<String>> res){
        if(cur.equals(beginWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        for(String precursor : from.get(cur)){
            path.addFirst(precursor);
            dfs(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
