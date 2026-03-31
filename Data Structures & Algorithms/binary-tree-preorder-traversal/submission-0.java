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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        preOrder(lst,root);
        return lst;
    }

    public void preOrder(List<Integer> lst, TreeNode root){
        if(root==null){
            return;
        }
        lst.add(root.val);
        preOrder(lst,root.left);
        preOrder(lst,root.right);
    }
}