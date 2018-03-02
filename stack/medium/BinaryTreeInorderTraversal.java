package Stack.Medium;

import Tree.TreeNode;
import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Acceptance: 48.6%
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1, null, 2, 3]
 *      1
 *       \
 *        2
 *       /
 *      3
 * return [1,3,2]
 *
 * Note : Recursive solution is trivial, could you do it iteratively?
 *
 * @author rovo98
 * Date: 17/2/2018
 */
public class BinaryTreeInorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> inorderTraversalRecursion(List<Integer> list, TreeNode root) {
        if (root != null) {
            list = inorderTraversalRecursion(list, root.left);
            list.add(root.val);
            list = inorderTraversalRecursion(list, root.right);
        }
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new LinkedStack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek() != null) {
                stack.push(stack.peek().left);
            }
            stack.pop();          // Remove the empty nodes.
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                stack.push(node.right);
            }
        }
        return list;
    }
    // Driver the program to test the method above.
    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode testTree = new TreeNode(1);
        TreeNode secNode = new TreeNode(2);
        secNode.left = new TreeNode(3);
        testTree.right = secNode;

        List<Integer> list = btit.inorderTraversal(testTree);
        System.out.println("The inOrder of the test binary tree is the following:");
        for (int node : list) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
