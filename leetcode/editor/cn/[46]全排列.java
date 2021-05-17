//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1339 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //回溯法 （向part添加的思路）
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        boolean[] isUse = new boolean[nums.length];
        dfs(nums,res,part,0,isUse);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> part,int index,boolean[] isUse){
        if(index == nums.length){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!isUse[i]) {
                part.add(nums[i]);
                isUse[i] = true;

                dfs(nums,res,part,index + 1,isUse);

                isUse[i] = false;
                part.remove(part.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
