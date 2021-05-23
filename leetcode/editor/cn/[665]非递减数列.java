//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 
// 👍 583 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++){
            int x = nums[i], y = nums[i + 1];
            if(x > y){
                //cnt记录前面大于后面的次数
                cnt++;
                if(cnt > 1) return false;
                //当i > 0 时，判断 num[i + 1] 和 num[i - 1]之间的关系
                //如果 num[i - 1] > num[i + 1],相当于 num[i + 1] < num[i - 1] < num[i]
                //此时我们直接将最大的num[i]赋值给num[i + 1]
                //相当于这三个值之间调整为非降序了，如果后续值还出现前面的大于后面的返回false
                if(i > 0 && y < nums[i - 1]){
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
