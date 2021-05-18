//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 306 👎 0


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
    List<Integer> ansList = new ArrayList<>();
    int count,base,maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    public void update(int val){
        if(val == base){
            count++;
        }else {
            count = 1;
            base = val;
        }

        //众数可能出现多个的情况
        if(count == maxCount){
            ansList.add(base);
        }

        if(count > maxCount){
            maxCount = count;
            ansList.clear();
            ansList.add(base);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
