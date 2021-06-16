//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 数学 回溯算法 
// 👍 523 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count;
    public String getPermutation(int n, int k) {
        //回溯法
        boolean[] visited = new boolean[n];
        List<Integer> res = new ArrayList<>();
        res = backTrace(n,k,visited,new ArrayList<>());
        StringBuffer str = new StringBuffer();
        for (Integer num : res) {
            str.append(num);
        }
        return str.toString();
    }

    public List<Integer> backTrace(int n, int k,boolean[] visited,List<Integer> res){
        if(res.size() == n){
            count++;
            return res;
        }else {
            for (int i = 1; i <= n; i++){
                if(!visited[i - 1]){
                    visited[i - 1] = true;
                    res.add(i);
                    backTrace(n, k, visited, res);
                    if(count == k){
                        return res;
                    }
                    visited[i - 1] = false;
                    res.remove(res.size() - 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
