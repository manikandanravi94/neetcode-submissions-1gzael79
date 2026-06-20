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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
       Queue<TreeNode> que = new ArrayDeque();
       if(root==null)
       return res;
       que.add(root);
       boolean isLeft=false;
       while(!que.isEmpty()){
        int size = que.size();
            isLeft= !isLeft;
            Deque<Integer> curr = new LinkedList<>();
        for(int i=0;i<size;i++){
             TreeNode del = que.poll();
             if(del.left!=null)
             que.add(del.left);
             if(del.right!=null)
             que.add(del.right);
             if(isLeft)
             curr.addLast(del.val);
             else
             curr.addFirst(del.val);
        }
        res.add(new ArrayList(curr));
       }
        return res;
    }
}