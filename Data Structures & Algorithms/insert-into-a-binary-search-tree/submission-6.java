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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        insert(root,root,val);
        return root;
    }

    public void insert(TreeNode root, TreeNode prev, int val){
        if(root==null){
            TreeNode nn = new TreeNode(val);
            if(prev.val>val){
                prev.left=nn;
            }else{
                prev.right=nn;
            }
            return;
        }

        if(root.val>val){
            insert(root.left,root,val);
        }else{
            insert(root.right,root,val);
        }
    }
}