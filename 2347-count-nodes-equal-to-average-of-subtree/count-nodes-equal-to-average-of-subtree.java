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
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        f(root);
        return res;
    }
    public int[] f(TreeNode root){
        if(root==null) return new int[]{0,0}; //sum,nodesCount
        int left[]=f(root.left);
        int right[]=f(root.right);

        int sum=left[0]+right[0]+root.val;
        int nodesCount=left[1]+right[1]+1;
        if(sum/nodesCount==root.val){
            res++;
        }
        return new int[]{sum,nodesCount};
    }
}