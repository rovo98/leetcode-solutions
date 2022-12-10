package com.rovo98.leetcode.l75.day6;

import com.rovo98.leetcode.common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 */
public class P589NaryTreePreorderTraversal {
    /*
    TC: O(n)
    SC: O(n)
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            Node n = stack.pop();
            result.add(n.val);
            if (n.children != null && !n.children.isEmpty()) {
                for (int i = n.children.size() - 1; i >= 0; i--) {
                    stack.push(n.children.get(i));
                }
            }
        }
        return result;
    }
}
