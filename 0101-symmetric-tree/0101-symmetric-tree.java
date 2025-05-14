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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetrical(root,root);
    }

    public boolean isSymmetrical(TreeNode nodeA, TreeNode nodeB){
        if(nodeA == null && nodeB == null) return true;
        if(nodeA == null || nodeB == null) return false;

        if(nodeA.val == nodeB.val){
            return isSymmetrical(nodeA.left,nodeB.right) && isSymmetrical(nodeA.right,nodeB.left);
        }
        return false;
    }
}