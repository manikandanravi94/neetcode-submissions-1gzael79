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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> op = new ArrayList<>();

        if(root==null){
            return op;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
         int size=queue.size();
         for(int i=0;i<size;i++){
            TreeNode remEle=queue.poll();
            if(i==size-1){
                op.add(remEle.val);
            }
            
            if(remEle.left!=null)
            queue.add(remEle.left);
            if(remEle.right!=null)
            queue.add(remEle.right);
         }

         size=queue.size();
        }
        return op;
    }
}
