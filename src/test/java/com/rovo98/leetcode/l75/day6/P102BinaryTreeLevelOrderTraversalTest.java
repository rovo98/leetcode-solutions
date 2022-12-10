package com.rovo98.leetcode.l75.day6;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class P102BinaryTreeLevelOrderTraversalTest
        implements SolutionProviderFactory<P102BinaryTreeLevelOrderTraversal> {
    @Override
    public P102BinaryTreeLevelOrderTraversal createSolutionProvider() {
        return new P102BinaryTreeLevelOrderTraversal();
    }

    @Test
    public void testcase1() {
        // [3, 9, 20, null, null, 15, 7]
        TreeNode root =
                new TreeNode(
                        3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        // [[3], [9,20], [15,7]]
        List<List<Integer>> expected = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
        assertTrue(isNestedListEq(expected, createSolutionProvider().levelOrder(root)));
    }

    @Test
    public void testcase2() {
        // [1]
        TreeNode root = new TreeNode(1);
        // [[1]]
        List<List<Integer>> expected = List.of(List.of(1));
        assertTrue(isNestedListEq(expected, createSolutionProvider().levelOrder(root)));
    }

    @Test
    public void testcase3() {
        // []
        TreeNode root = null;
        // []
        List<List<Integer>> expected = new ArrayList<>();
        assertTrue(isNestedListEq(expected, createSolutionProvider().levelOrder(root)));
    }

    private boolean isNestedListEq(List<List<Integer>> l1, List<List<Integer>> l2) {
        if (l1 == null) return null == l2;
        if (l1.size() != l2.size()) return false;

        for (int i = 0; i < l1.size(); i++) {
            List<Integer> e1 = l1.get(i);
            List<Integer> e2 = l2.get(i);
            if (e1.size() != e2.size()) return false;
            else {
                for (int j = 0; j < e1.size(); j++) {
                    if (!Objects.equals(e1.get(j), e2.get(j))) return false;
                }
            }
        }
        return true;
    }
}
