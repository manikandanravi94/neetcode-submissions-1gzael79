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
    public boolean isValidBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        dfs(root,lst);
        for(int i=1;i<lst.size();i++){
          if(lst.get(i)<=lst.get(i-1)){
            return false;
          }
        }
        return true;
    }

    public void dfs(TreeNode root,List<Integer> lst){
        if(root==null){
            return;
        }
        dfs(root.left,lst);
        lst.add(root.val);
        dfs(root.right,lst);
    }
}
