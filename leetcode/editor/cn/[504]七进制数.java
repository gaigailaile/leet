//给定一个整数，将其转化为7进制，并以字符串形式输出。 
//
// 示例 1: 
//
// 
//输入: 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: -7
//输出: "-10"
// 
//
// 注意: 输入范围是 [-1e7, 1e7] 。 
// 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        //进制通用方法
        if(num == 0){
            return "0";
        }

        StringBuffer res = new StringBuffer();
        boolean flag = false;
        if(num < 0){
            flag = true;
            num = -num;
        }

        // 求进制的模板，转换成几进制，就先求余几，然后再除以几
        while (num != 0) {
            res.append(num % 7);
            num /= 7;
        }
        res.reverse();
        return flag ? "-" + res.toString() : res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
