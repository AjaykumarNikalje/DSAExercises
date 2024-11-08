package org.example.dynamicProgramming.DpForTrees;

import java.util.HashMap;
import java.util.Map;


class MaximumPathSumMemoization {
    static TreeNode root;

    class Res {
        int val;
    }

    // Method to calculate the maximum path sum of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Res res=new Res();
        Map<TreeNode, Integer> memo = new HashMap<>(); // Memoization map
        depth(root, memo,res);
        return res.val ;
    }

    // Helper method to calculate the depth and update the maximum path sum
    public int depth(TreeNode node, Map<TreeNode, Integer> memo,Res res) {
        if (node == null) return 0;

        // Check if the value is already computed
        if (memo.containsKey(node)) return memo.get(node);

        // Recursively calculate the depth of left and right subtrees
        int leftDepth = depth(node.left, memo,res);
        int rightDepth = depth(node.right, memo,res);

        int temp=Math.max(Math.max(leftDepth, rightDepth) + node.val, node.val );

        // Calculate the maximum path sum through the current node
        int currentSol = Math.max(leftDepth,0) +  Math.max(rightDepth,0) + node.val;

        // Store the maximum path sum found so far
        int ans = Math.max(temp,currentSol);
        res.val=Math.max(res.val,ans);

        System.out.println("temp: "+temp);
        System.out.println("currentSol: "+currentSol);
        System.out.println("ans: "+ans);
        // Update the memoization map with the current node's max path sum
        memo.put(node, temp);

        return temp;
    }

    public static void main(String[] args) {
        MaximumPathSumMemoization tree = new MaximumPathSumMemoization();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(-25);
        tree.root.right.right.left = new TreeNode(3);
        tree.root.right.right.right = new TreeNode(4);

        System.out.println("Maximum Path Sum from Any Node to Any Node (Can skip negetive nodes )  with Memoization is " + tree.diameterOfBinaryTree(root));
    }
}