package org.example.dynamicProgramming.DpForTrees;

import java.util.HashMap;
import java.util.Map;

class DiameterOfTreeMemoization {

    class Res {
        int val;
    }

    static TreeNode root;

    // Memoization map to store the depth of each subtree, using TreeNode as key
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        depth(root, res);
        return res.val ;
    }

    public int depth(TreeNode node, Res res) {
        if (node == null)
            return 0;

        // Check if the result for this node's depth is already memoized
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int L = depth(node.left, res);
        int R = depth(node.right, res);

        int temp = Math.max(L, R) + 1; // Current node's height
        int ans = Math.max(temp, L + R + 1); // Diameter considering this node as the root
        res.val = Math.max(res.val, ans); // Update maximum diameter

        // Memoize the result using the TreeNode reference
        memo.put(node, temp);

        return temp;
    }

    public static void main(String args[]) {
        DiameterOfTreeMemoization tree = new DiameterOfTreeMemoization();
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
        System.out.println("Max pathSum of the given binary tree is " + tree.diameterOfBinaryTree(root));
    }
}
