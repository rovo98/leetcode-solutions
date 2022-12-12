package com.rovo98.leetcode.l75.day8;

import com.rovo98.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/** https://leetcode.com/problems/validate-binary-search-tree */
public class P98ValidateBinarySearchTree {

    /*
    in-order traversal
    TC: O(n)
    SC: O(1)
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root != null) {
            stack.push(root);
        }
        TreeNode p = root;
        while (p.left != null) {
            p = p.left;
            stack.push(p);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                TreeNode it = node.right;
                while (it.left != null) {
                    it = it.left;
                    stack.push(it);
                }
            }
            if (stack.peek() != null) {
                if (node.val >= stack.peek().val) {
                    return false;
                }
            }
        }
        return true;
    }
}
