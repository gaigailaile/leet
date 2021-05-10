//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1299 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        dfs(digits,0,"");
        return res;
    }

    public void dfs(String s,int i,String ans){
        if(i == s.length()){
            res.add(ans);
            return;
        }
        String let = map.get(s.charAt(i));
        for(int k = 0; k < let.length(); k++){
            ans += let.charAt(k);
            dfs(s,i+1,ans);
            //回溯字符
            ans = ans.substring(0,i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
