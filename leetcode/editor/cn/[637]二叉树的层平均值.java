//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 260 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //两个集合存放个数 和 总和
    List<Double> res = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        //深度优先
        dfs(root,0);
        for (int i = 0; i < res.size(); i++) res.set(i,res.get(i) / count.get(i));
        return res;
    }

    //需要一个深度记录层数
    public void dfs(TreeNode root,int dept){
        if(root == null) return;
        if(dept < res.size()){
            res.set(dept,res.get(dept) + root.val);
            count.set(dept,count.get(dept) + 1);
        }else {
            res.add(1.0 * root.val);
            count.add(1);
        }
        dfs(root.left,dept + 1);
        dfs(root.right,dept + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
