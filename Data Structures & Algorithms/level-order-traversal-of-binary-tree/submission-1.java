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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
        return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> lst=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode deleteNode=queue.poll();
                lst.add(deleteNode.val);
                if(deleteNode.left!=null)
                queue.add(deleteNode.left);
                if(deleteNode.right!=null)
                queue.add(deleteNode.right);
            }
            result.add(new ArrayList<>(lst));

        }
        return result;
    }
}
