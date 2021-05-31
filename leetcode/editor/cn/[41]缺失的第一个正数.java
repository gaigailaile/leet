//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1089 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        //将数字移动到它应该在的位置
        for(int i = 0; i < nums.length; i++){
            while (nums[i] - 1 != i){
                if(nums[i] <= 0 || nums[i] > nums.length) break;
                if(nums[nums[i] - 1] == nums[i]) break;

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        //判断
        for (int i = 1; i <= nums.length; i++){
            if(nums[i - 1] != i){
                return i;
            }
        }

        return nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
