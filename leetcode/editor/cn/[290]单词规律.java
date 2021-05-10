//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 334 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        //哈希表 不使用split方法
        HashMap<String,Character> sMap = new HashMap<>();
        HashMap<Character,String> cMap = new HashMap<>();
        int m = s.length();
        int l = 0;
        for(int i = 0; i < pattern.length(); i++){
            if(l >= m) return false;
            char ch = pattern.charAt(i);
            int j = l;
            while (j < m && s.charAt(j) != ' ') j++;
            String str = s.substring(l,j);
            if(sMap.containsKey(str) && sMap.get(str) != ch){
                return false;
            }
            if(cMap.containsKey(ch) && !cMap.get(ch).equals(str)){
                return false;
            }
            sMap.put(str,ch);
            cMap.put(ch,str);
            l = j + 1;
        }
        return l >= m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
