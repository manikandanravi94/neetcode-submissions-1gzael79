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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList();
        postOrder(lst,root);
        return lst;
    }

    private void postOrder(List<Integer> lst, TreeNode root){
        if(root == null){
            return;
        }
        postOrder(lst,root.left);
        postOrder(lst,root.right);
        lst.add(root.val);
    }
}