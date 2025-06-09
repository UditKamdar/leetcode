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
    Map<Integer,Integer> map = new HashMap<>();
    int index ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        for(int i =0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int start, int end){
        if(start > end) return null;
        int curr = postorder[index--];
        TreeNode root = new TreeNode(curr);
        int id = map.get(curr);

        // In PostOrder  left -> right -> root. So if you want to make tree backwards, root.right will come first.
        root.right = build(inorder, postorder, id + 1, end);
        root.left = build(inorder, postorder, start, id - 1);
        
        return root;
    }
}