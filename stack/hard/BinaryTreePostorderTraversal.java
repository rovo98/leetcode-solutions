package Stack.Hard;

import Tree.TreeNode;
import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Acceptance: 41.35
 *
 * Given a binary tree, return the post-order traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3}
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 *  return [3,2,1]
 *
 *  Note : Recursive solution is trivial, could you do it iteratively?
 *
 * @author rovo98
 * Date: 17/2/2018
 * Date: 22/2/2018 review.
 */
public class BinaryTreePostorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> postorderTraversalRecursion(List<Integer> list, TreeNode root) {
        if (root != null) {
            list = postorderTraversalRecursion(list, root);
            list = postorderTraversalRecursion(list, root);
            list.add(root.val);
        }
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        /*
        use two stacks.
         */
        Stack<TreeNode> stack_one = new LinkedStack<>();
        Stack<TreeNode> stack_two = new LinkedStack<>();
        List<Integer> list = new ArrayList<>();
        stack_one.push(root);

        while (!stack_one.isEmpty()) {
            TreeNode node = stack_one.pop();
            stack_two.push(node);
            if (node.left != null) {
                stack_one.push(node.left);
            }
            if (node.right != null) {
                stack_one.push(node.right);
            }
        }
        while (!stack_two.isEmpty()) {
            list.add(stack_two.pop().val);
        }
        return list;
    }

    // Driver the program to test the method above.
    public static void main(String[] args) {
        BinaryTreePostorderTraversal btpt = new BinaryTreePostorderTraversal();
        TreeNode testTree = new TreeNode(1);
        TreeNode secNode = new TreeNode(2);
        secNode.left = new TreeNode(3);
        testTree.right = secNode;

        List<Integer> list = btpt.postorderTraversal(testTree);
        System.out.println("The post order traversal for the test tree is the following:");
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
