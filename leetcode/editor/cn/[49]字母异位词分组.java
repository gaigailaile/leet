//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 734 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //应为字母内容一致，可以排序后作为key
        HashMap<String,List<String>> res = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            int len = str.length();
            for (int i = 0; i < len; i++){
                count[str.charAt(i) - 'a']++;
            }
            StringBuffer keyBuffer = new StringBuffer();
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    keyBuffer.append((char) ('a' + i));
                    keyBuffer.append(count[i]);
                }
            }
            String key = keyBuffer.toString();
            List<String> temp = res.getOrDefault(key,new ArrayList<>());
            temp.add(str);
            res.put(key,temp);
        }
        return new ArrayList<List<String>>(res.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
