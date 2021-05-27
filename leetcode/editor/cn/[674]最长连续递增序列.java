//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 184 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //贪心
        int start = 0;
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            if(i > 0 && nums[i] <= nums[i-1]){
                start = i;
            }
            //start为开始的位置，i为结束的位置
            ans = Math.max(ans,i - start + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
