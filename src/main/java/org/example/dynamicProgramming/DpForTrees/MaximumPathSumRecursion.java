package org.example.dynamicProgramming.DpForTrees;


class MaximumPathSumRecursion {

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

        int temp = Math.max(Math.max(leftDepth, rightDepth) + node.val, node.val ) ;
        int currentSol=Math.max(leftDepth,0) +  Math.max(rightDepth,0) + node.val;
        int ans = Math.max(temp,currentSol );
        res.val = Math.max(res.val, ans);

        // Return the depth of the current node
        return temp;
    }

    public static void main(String[] args) {
        MaximumPathSumRecursion tree = new MaximumPathSumRecursion();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(-25);
        tree.root.right.right.left = new TreeNode(3);
        tree.root.right.right.right = new TreeNode(4);


        System.out.println("Maximum Path Sum from Any Node to Any Node (Can skip negetive nodes ) Recursion is " + tree.diameterOfBinaryTree(root));
    }
}
