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
    public int averageOfSubtree(TreeNode root) {
        int res[]=new int[]{0};
        f(root,res);
        return res[0];
    }
    public static int[] f(TreeNode root,int res[]){
        if(root==null) return new int[]{0,0}; //sum,nodesCount
        int left[]=f(root.left,res);
        int right[]=f(root.right,res);

        int sum=left[0]+right[0]+root.val;
        int nodesCount=left[1]+right[1]+1;
        if(sum/nodesCount==root.val){
            res[0]++;
        }
        return new int[]{sum,nodesCount};
    }
}