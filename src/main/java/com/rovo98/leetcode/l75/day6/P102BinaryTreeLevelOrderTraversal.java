package com.rovo98.leetcode.l75.day6;

import com.rovo98.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal
 */
public class P102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.push(root);
        }
        List<TreeNode> temp = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode n = queue.pop();
            list.add(n.val);
            if (n.left != null) {
                temp.add(n.left);
            }
            if (n.right != null) {
                temp.add(n.right);
            }
            if (queue.isEmpty()) {
                queue.addAll(temp);
                result.add(
                        new ArrayList<>() {
                            {
                                addAll(list);
                            }
                        });
                temp.clear();
                list.clear();
            }
        }
        return result;
    }
}
