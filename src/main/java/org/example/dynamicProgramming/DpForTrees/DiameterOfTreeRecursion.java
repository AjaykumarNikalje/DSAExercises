package org.example.dynamicProgramming.DpForTrees;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class DiameterOfTreeRecursion {

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

        // Update the maximum diameter: leftDepth + rightDepth + 1 for the current node
        int tempDiameter = Math.max(leftDepth, rightDepth) + 1;
        int currentDiameter = leftDepth + rightDepth + 1;  // Diameter through current node

        // Update the maximum diameter found so far
        res.val = Math.max(res.val, currentDiameter);

        // Return the depth of the current node
        return tempDiameter;
    }

    public static void main(String[] args) {
        DiameterOfTreeRecursion tree = new DiameterOfTreeRecursion();
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

        System.out.println("Diameter of the given binary tree is " + tree.diameterOfBinaryTree(root));
    }
}
