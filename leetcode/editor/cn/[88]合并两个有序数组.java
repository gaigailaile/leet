//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 940 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = nums1.length - 1;
        //从后向前比 谁大放在nums1的末尾
        while (m > 0 || n > 0){
            if(m > 0 && n > 0){
                if(nums1[m-1] > nums2[n - 1]){
                    nums1[size] = nums1[--m];
                }else {
                    nums1[size] = nums2[--n];
                }
            }else if(m > 0){
                break;
            }else if(n > 0){
                nums1[size] = nums2[--n];
            }
            size--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
