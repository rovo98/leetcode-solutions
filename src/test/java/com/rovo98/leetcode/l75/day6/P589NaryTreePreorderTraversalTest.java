package com.rovo98.leetcode.l75.day6;

import com.rovo98.leetcode.SolutionProviderFactory;
import com.rovo98.leetcode.common.Node;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class P589NaryTreePreorderTraversalTest
        implements SolutionProviderFactory<P589NaryTreePreorderTraversal> {
    @Override
    public P589NaryTreePreorderTraversal createSolutionProvider() {
        return new P589NaryTreePreorderTraversal();
    }

    @Test
    public void testcase1() {
        Node root =
                new Node(
                        1,
                        List.of(
                                new Node(3, List.of(new Node(5), new Node(6))),
                                new Node(2),
                                new Node(4)));
        List<Integer> expected = List.of(1, 3, 5, 6, 2, 4);
        assertTrue(isListEq(expected, createSolutionProvider().preorder(root)));
    }

    @Test
    public void testcase2() {
        Node root =
                new Node(
                        1,
                        List.of(
                                new Node(2),
                                new Node(
                                        3,
                                        List.of(
                                                new Node(6),
                                                new Node(
                                                        7,
                                                        List.of(
                                                                new Node(
                                                                        11,
                                                                        List.of(new Node(14))))))),
                                new Node(4, List.of(new Node(8, List.of(new Node(12))))),
                                new Node(
                                        5,
                                        List.of(
                                                new Node(9, List.of(new Node(13))),
                                                new Node(10)))));
        List<Integer> expected = List.of(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10);
        assertTrue(isListEq(expected, createSolutionProvider().preorder(root)));
    }

    private boolean isListEq(List<Integer> l1, List<Integer> l2) {
        if (l1 == null || l2 == null) return l1 == l2;
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))) return false;
        }
        return true;
    }
}
