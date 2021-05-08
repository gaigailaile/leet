//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 972 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //排序法
        sort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }

    public int[] sort(int[] nums,int low,int high){
        int start = low;
        int end = high;
        int key = nums[low];
        while (end > start) {
            while (end > start && nums[end] >= key) end--;
            if(key > nums[end]) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            while (end > start && nums[start] <= key) start++;
            if(key < nums[start]) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
        }
        if(start > low) sort(nums,low,start-1);
        if(end < high) sort(nums,end+1,high);
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
