//给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。 
//
// 
//
// 示例： 
//
// 
//输入：
//[1,2,3]
//输出：
//3
//解释：
//只需要3次操作（注意每次操作会增加两个元素的值）：
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
// Related Topics 数学 
// 👍 219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {
        //数学法
        int move = 0, min = Integer.MAX_VALUE;
        for (int num : nums){
            if(num < min) min = num;
        }
        for (int i = 0; i < nums.length; i++){
            move += nums[i] - min;
        }
        return move;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
