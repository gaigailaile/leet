//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4094 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //二分查找
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        double res = 0;
        if(len % 2 == 1){
            res = getKth(nums1,nums2,(len / 2) + 1);
        }else {
            res = (getKth(nums1,nums2,len / 2) + getKth(nums1,nums2,len / 2 + 1)) / 2.0;
        }
        return res;
    }

    public int getKth(int[] nums1, int[] nums2,int k){
        int m = nums1.length,n = nums2.length;
        int index1 = 0,index2 = 0;

        while (true){
            //边界情况
            if(index1 == m){
                return nums2[index2 + k - 1];
            }
            if(index2 == n){
                return nums1[index1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            //正常情况 将k一分为2
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid,m) - 1;
            int newIndex2 = Math.min(index2 + mid,n) - 1;
            int temp1 = nums1[newIndex1],temp2 = nums2[newIndex2];
            if (temp1 <= temp2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
