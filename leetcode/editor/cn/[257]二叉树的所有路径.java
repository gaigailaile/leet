//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 493 👎 0


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
    public List<String> binaryTreePaths(TreeNode root) {
        //广度优先算法
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<String> pathQ = new LinkedList<>();
        nodeQ.offer(root);
        pathQ.offer(Integer.toString(root.val));
        while (!nodeQ.isEmpty()){
            TreeNode node = nodeQ.poll();
            String path = pathQ.poll();
            if(node.left == null && node.right == null) {
                res.add(path);
            }else{
                if(node.left != null){
                    nodeQ.offer(node.left);
                    pathQ.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if(node.right != null){
                    nodeQ.offer(node.right);
                    pathQ.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
