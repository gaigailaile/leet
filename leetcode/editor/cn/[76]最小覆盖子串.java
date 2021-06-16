//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //记录t中的字符及其个数
    HashMap<Character, Integer> ori = new HashMap<>();
    HashMap<Character,Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        //滑动窗口
        int tLen = t.length();
        for (int i = 0; i < tLen; i++){
            char ch = t.charAt(i);
            ori.put(ch,ori.getOrDefault(ch,0) + 1);
        }
        //定义窗口左右边界
        int left = 0, right = -1;
        //定义答案的左右边界
        int ansL = -1, ansR = -1;
        int len = Integer.MAX_VALUE, sLen = s.length();

        while (right < sLen){
            right++;
            if(right < sLen && ori.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right),cnt.getOrDefault(s.charAt(right),0) + 1);
            }

            while (check() && left <= right){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if(ori.containsKey(s.charAt(left))){
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0) - 1);
                }
                left++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }

    public boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Character key = (Character)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(cnt.getOrDefault(key,0) < val){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
