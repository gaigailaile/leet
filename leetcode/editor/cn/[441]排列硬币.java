//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 103 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        //二分法
        //答案的范围是[0,n]的有序区间，所以可以使用二分查找。我们在[0，n]中找到一个数K(代码中的mid)
        //使（1 + k）* k / 2刚好小于等于n, 如果大于n,就排除一半区间
        long left = 0,right = n;
        while (left < right){
            long mid = left + (right - left + 1) / 2;
            long sum = (1 + mid) * mid / 2;
            if(sum > n){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int) left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
