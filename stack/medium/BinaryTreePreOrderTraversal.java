package Stack.Medium;

import Tree.TreeNode;
import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Acceptance: 46.1%
 *
 * Given a binary tree, return the preOrder traversal of its nodes's values.
 *
 * For example:
 * Given binary tree [1,null,2,3]
 *
 *      1
 *       \
 *        2
 *       /
 *      3
 *
 * return [1,2,3]
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author rovo98
 * Date: 17/2/2018
 */
public class BinaryTreePreOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> preOrderTraversalRecursion(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            list = preOrderTraversalRecursion(list, root.left);
            list = preOrderTraversalRecursion(list, root.right);
        }
        return list;
    }
    public List<Integer> preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new LinkedStack<>();
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            while (node != null) {
                if (node.left != null) {
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
        }
        return list;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        BinaryTreePreOrderTraversal btpt = new BinaryTreePreOrderTraversal();
        TreeNode testTree = new TreeNode(1);
        TreeNode secNode = new TreeNode(2);
        secNode.left = new TreeNode(3);
        testTree.right = secNode;

        List<Integer> list = new ArrayList<>();
        list = btpt.preOrderTraversalRecursion(list, testTree);
        System.out.println("The preorder of the test tree using recursion function is the following:");
        for (int e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
        List<Integer> list1;
        list1 = btpt.preOrderTraversal(testTree);
        System.out.println("The preOrder of the test tree is the following:");
        for (int e : list1) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
