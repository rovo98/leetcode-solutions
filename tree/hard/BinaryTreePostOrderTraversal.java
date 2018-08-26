package Tree.Hard;

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
 *
 */
public class BinaryTreePostOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> postOrderTraversalRecursion(List<Integer> list, TreeNode root) {
        if (root != null) {
            list = postOrderTraversalRecursion(list, root.left);
            list = postOrderTraversalRecursion(list, root.right);
            list.add(root.val);
        }
        return list;
    }
    public List<Integer> postOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack_one = new LinkedStack<>();
        Stack<TreeNode> stack_two = new LinkedStack<>();
        List<Integer> list = new ArrayList<>();
        /*
        stack_one : root -> root.left -> root.right
        stack_two : root -> root.right -> root.left.

        output from the stack_two : root-left -> root.right -> root. (postOrder).
         */
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

    //Derive the program to test the method above.
    public static void main(String[] args) {
        BinaryTreePostOrderTraversal btpt = new BinaryTreePostOrderTraversal();
        TreeNode testTree = new TreeNode(1);
        TreeNode secNode = new TreeNode(2);
        secNode.left = new TreeNode(3);
        testTree.right = secNode;
        List<Integer> list = btpt.postOrderTraversal(testTree);
        System.out.println("The postOrder traversal of the test tree is the following:");
        for (int elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
