//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
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
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
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
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 数学 
// 👍 195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        if(s.length() == 0) return false;
        char[] chars = s.toCharArray();
        //记录E或e出现次数
        int eCount = 0;
        //记录小数点出现次数
        int pCount = 0;

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' ') return false;

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
