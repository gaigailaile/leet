//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法 
// 👍 691 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        //贪心法
        //从右向前匹配，遇到第一个*停止
        int sRight = s.length(),pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*'){
            if(match(s.charAt(sRight - 1),p.charAt(pRight - 1))){
                sRight--;
                pRight--;
            } else {
                return false;
            }
        }

        //pRight为0代表，p内没有*.此时如果sRight为0证明他们完全匹配
        if(pRight == 0) return sRight == 0;

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight){
            if(p.charAt(pIndex) == '*'){
                pIndex++;
                sRecord = sIndex;
                pRecord = pIndex;
            }else if(match(s.charAt(sIndex),p.charAt(pIndex))){
                sIndex++;
                pIndex++;
            }else if(sRecord != -1 && sRecord + 1 != sRight){
                //如果sRecord不为-1说明之前匹配过*，有回滚的机会
                sRecord++;
                sIndex = sRecord;
                pIndex = pRecord;
            }else {
                return false;
            }
        }

        //当s匹配完成后,p不能有*以外的字符
        return allStar(p,pIndex,pRight);
    }

    public boolean allStar(String str, int left, int right){
        for (int i = left; i < right; ++i) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean match(char s,char p){
        return s == p || p == '?';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
