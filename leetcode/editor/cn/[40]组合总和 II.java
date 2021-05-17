//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 573 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序 + 回溯
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();

        dfs(candidates,target,0,candidate,res);

        return res;
    }

    public void dfs(int[] candidates,int target,int index,List<Integer> candidate,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(candidate));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            //target 小于当前值，那么后面的值都大于target. 所有结果小于0 剪枝
            if(target - candidates[i] < 0){
                break;
            }
            //同层的相同元素剪枝 （i 越小可能性越多，故将后面的减掉）
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            candidate.add(candidates[i]);
            dfs(candidates,target - candidates[i],i + 1,candidate,res);
            candidate.remove(candidate.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
