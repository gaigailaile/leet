//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 371 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        //模拟法
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer str = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + add;
            str.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        return str.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
