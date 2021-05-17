//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 631 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];

        for (int i = 0; i < n1; i++){
            nums1[i] = num1.charAt(i) - '0';
        }

        for(int j = 0; j < n2; j++){
            nums2[j] = num2.charAt(j) - '0';
        }

        int[] resNums = new int[n1 + n2];
        for (int i = 0; i < n1; i++){
            for (int j = 0; j < n2; j++){
                resNums[i + j] += nums1[i] * nums2[j];
            }
        }

        for (int k = resNums.length - 1; k > 0; k--){
            resNums[k - 1] += resNums[k] / 10;
            resNums[k] = resNums[k] % 10;
        }

        StringBuffer res = new StringBuffer();
        for(int i = 0;i < resNums.length - 1;i++ ){
            res.append(resNums[i]);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
