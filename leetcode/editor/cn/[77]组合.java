//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 580 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //回溯法
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        List<Integer> cur = new ArrayList<>();
        dfs(res,cur,n,k,1);
        return res;
    }

    public void dfs(List<List<Integer>> res,List<Integer> cur,int n,int k,int index){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        //这里进行剪枝 n - (k - cur.size()) + 1
        for(int i = index; i <= n - (k - cur.size()) + 1; i++){
            cur.add(i);
            dfs(res, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
