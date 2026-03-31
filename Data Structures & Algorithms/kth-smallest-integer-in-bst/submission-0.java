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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        dfs(root,k, lst);
        return lst.get(k-1);
    }

    public void dfs(TreeNode root, int k, List<Integer> lst){
        if(lst.size()==k){
            return;
        }

        if(root.left!=null)dfs(root.left,k,lst);
        lst.add(root.val);
        if(root.right!=null)
        dfs(root.right,k,lst);
    }
}
