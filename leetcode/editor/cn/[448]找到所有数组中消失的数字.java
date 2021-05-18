//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 736 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //使用nums作为哈希表,将各值本来应该在的位置上都加上一个n
        //第二次遍历一遍后如果当前值小于等于n（其他位置） 说明当前位置所代表的的值消失了

        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if(nums[i] <= n){
                res.add(i + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
