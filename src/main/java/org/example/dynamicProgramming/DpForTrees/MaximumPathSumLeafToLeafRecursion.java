package org.example.dynamicProgramming.DpForTrees;

class MaximumPathSumLeafToLeafRecursion {

    class Res {
        int val;
    }

    static TreeNode root;

    // Method to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;  // Initialize result holder for max diameter
        depth(root, res);
        return res.val ;
    }

    // Helper method to calculate the depth and update the diameter
    public int depth(TreeNode node, Res res) {
        if (node == null)
            return 0;

        // Recursively calculate the depth of left and right subtrees
        int leftDepth = depth(node.left, res);
        int rightDepth = depth(node.right, res);

        int temp = Math.max(leftDepth, rightDepth) + node.val;
        int currentSol=leftDepth +  rightDepth + node.val;
        int ans = Math.max(temp,currentSol );
        res.val = Math.max(res.val, ans);

        // Return the depth of the current node
        return temp;
    }

    public static void main(String[] args) {
        MaximumPathSumLeafToLeafRecursion tree = new MaximumPathSumLeafToLeafRecursion();
        tree.root = new TreeNode(-15);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(6);
        tree.root.left.left = new TreeNode(-8);
        tree.root.left.right = new TreeNode(1);
        tree.root.left.left.left = new TreeNode(2);
        tree.root.left.left.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(9);
        tree.root.right.right.right = new TreeNode(0);
        tree.root.right.right.right.left = new TreeNode(4);
        tree.root.right.right.right.right = new TreeNode(-1);
        tree.root.right.right.right.right.left = new TreeNode(10);


        System.out.println("Maximum Path Sum Leaf to Leaf Recursion is " + tree.diameterOfBinaryTree(root));
    }
}
