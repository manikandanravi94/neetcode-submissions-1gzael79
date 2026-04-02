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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }


    private TreeNode build(int[] pre, int s1, int e1, int[] in, int s2, int e2){
        if(s1>e1){
            return null;
        }

        TreeNode root = new TreeNode(pre[s1]);
          
        int ind=0;

        for(int i=s2;i<=e2;i++){
            if(in[i]==pre[s1]){
                ind=i;
                break;
            }
        }
        int e=ind-s2;

        root.left=build(pre,s1+1,s1+e,in,s2,ind-1);
        root.right=build(pre,s1+e+1,e1,in,ind+1,e2);

        return root;
    }
}
