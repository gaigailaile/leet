//有效数字（按顺序）可以分成以下几个部分： 
//
// 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分有效数字列举如下： 
//
// 
// ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
// "53.5e93", "-123.456e789"] 
// 
//
// 部分无效数字列举如下： 
//
// 
// ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
// 
//
// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = ".1"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
// Related Topics 数学 字符串 
// 👍 187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        char[] chars = s.toCharArray();
        //记录E或e出现次数
        int eCount = 0;
        //记录小数点出现次数
        int pCount = 0;

        for(int i = 0; i < chars.length; i++){
            //第一位是+ - 跳过，中间出现盘点前一位是否为E、e
            if(chars[i] == '+' || chars[i] == '-'){
                //不能以+或-结尾
                if(i == chars.length - 1) return false;
                if(i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E'){
                    return false;
                }
                continue;
            }


            if(chars[i] == 'e' || chars[i] == 'E'){
                eCount++;
                if(eCount > 1) return false;
                //判断E或e出现的位置（不能以E或e开头、结尾）、判断E或e前一位是否为数字或.
                if(i == 0 || i == chars.length - 1 || (isNum(chars[i - 1]) && chars[i - 1] != '.')) return false;
                //E后面只能出现整数，这里我们将pCount++，当后面再出现.时个数会变成2不合法
                pCount++;
                continue;
            }

            if(chars[i] == '.'){
                pCount++;
                if(pCount > 1) return false;
                //不能单独存在 .
                if(i == 0 && i == chars.length - 1) return false;
                if(i == 0){
                    //判断.在首位判断后面是不是数字
                    if(isNum(chars[i + 1])) return false;
                }else if(i == chars.length - 1){
                    //判断.在末尾时前面是不是数字
                    if(isNum(chars[i - 1])) return false;
                }else if(isNum(chars[i - 1]) && isNum(chars[i + 1])){
                    //否则在中间判断前后至少有一个为数字
                    return false;
                }
                continue;
            }
            //判断是否有除了E e . + - 之外的特殊字符
            if(isNum(chars[i]) && chars[i] != 'e' && chars[i] != 'E'){
                return false;
            }
        }
        return true;
    }

    public boolean isNum(char ch){
        return ch < 48 || ch > 57;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
