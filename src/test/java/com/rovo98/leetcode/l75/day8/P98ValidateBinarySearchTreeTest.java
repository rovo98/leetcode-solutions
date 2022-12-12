package com.rovo98.leetcode.l75.day8;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class P98ValidateBinarySearchTreeTest
        implements SolutionProviderFactory<P98ValidateBinarySearchTree> {
    @Override
    public P98ValidateBinarySearchTree createSolutionProvider() {
        return new P98ValidateBinarySearchTree();
    }

    @Test
    public void testcase1() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertTrue(createSolutionProvider().isValidBST(root));
    }

    @Test
    public void testcase2() {
        TreeNode root =
                new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        assertFalse(createSolutionProvider().isValidBST(root));
    }

    @Test
    public void testcase3() {
        TreeNode root =
                new TreeNode(2, new TreeNode(2), new TreeNode(2));
        assertFalse(createSolutionProvider().isValidBST(root));
    }

    @Test
    public void testcase4() {
        TreeNode root =
                new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        assertFalse(createSolutionProvider().isValidBST(root));
    }

    @Test
    public void testcase5() {
        TreeNode root =
                new TreeNode(1, null, new TreeNode(1));
        assertFalse(createSolutionProvider().isValidBST(root));
    }

}
