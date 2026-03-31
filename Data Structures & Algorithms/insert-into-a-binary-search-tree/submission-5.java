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
        dfs(root,root,val);
        return root;
    }

    public void dfs(TreeNode root,TreeNode prev, int val){
        if(root==null){
            root=new TreeNode(val);
            if(prev.val>root.val){
                prev.left=root;
            }else{
              prev.right=root;
            }
            return;
        }

        if(root.val>val){
          dfs(root.left,root,val);
        }else{
            dfs(root.right,root,val);
        }


    }
}