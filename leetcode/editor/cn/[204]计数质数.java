//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 676 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        //去到质数后将能整除它的全部排出去
        int[] isPrimes = new int[n];
        Arrays.fill(isPrimes,1);
        int ans = 0;
        for (int i = 2; i < n; ++i){
            if (isPrimes[i] == 1){
                ans += 1;
                if((long)i*i < n){
                    for (int j = i * i; j < n; j += i){
                        isPrimes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
