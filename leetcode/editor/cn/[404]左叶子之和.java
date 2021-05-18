//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 312 👎 0


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
    public int sumOfLeftLeaves(TreeNode root) {
        //广度优先
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                if(isLeftNode(node.left)){
                    ans += node.left.val;
                }else {
                    queue.offer(node.left);
                }
            }

            if(node.right != null){
                if(!isLeftNode(node.right)){
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }

    public boolean isLeftNode(TreeNode root){
        return root.left == null && root.right == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
