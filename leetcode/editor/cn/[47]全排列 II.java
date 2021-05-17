//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //回溯法 （向part添加的思路）
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        boolean[] isUse = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,res,part,0,isUse);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> part,int index,boolean[] isUse){
        if(index == nums.length){
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if(isUse[i] || (i > 0 && nums[i] == nums[i - 1] && !isUse[i - 1])){
                continue;
            }
            part.add(nums[i]);
            isUse[i] = true;
            dfs(nums,res,part,index + 1,isUse);
            isUse[i] = false;
            part.remove(part.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
