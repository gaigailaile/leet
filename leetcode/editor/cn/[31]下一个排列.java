//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1105 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        //两遍扫描
        //第一次循环找到可交换位置（从后向前找这样才符合下一个排序的题意）
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        //如果i < 0 说明此时是最大排序 直接翻转即可
        if(i >= 0) {
            //从后寻找大于nums[i]的值进行交换
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i + 1);
    }

    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums,int start){
        int left = start,right = nums.length - 1;
        while (left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
