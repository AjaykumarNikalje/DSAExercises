package org.example;

class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class HeightOfTree {

    static Node root;

    public static void main(String[] args) {
        HeightOfTree tree = new HeightOfTree();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
        System.out.println("height "
                + tree.heightOfBinaryTree(root));

    }

    private int heightOfBinaryTree(Node root) {

        if(root == null)
            return 0;
        int left = heightOfBinaryTree(root.left);
        int right = heightOfBinaryTree(root.right);
        return Math.max(left, right) +1;
    }

}
