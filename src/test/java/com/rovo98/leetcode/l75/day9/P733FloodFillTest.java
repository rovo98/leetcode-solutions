package com.rovo98.leetcode.l75.day9;

import com.rovo98.leetcode.SolutionProviderFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class P733FloodFillTest implements SolutionProviderFactory<P733FloodFill> {

    @Override
    public P733FloodFill createSolutionProvider() {
        return new P733FloodFill();
    }

    @Test
    public void testcase1() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] expected = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        assertTrue(is2dArrEq(expected, createSolutionProvider().floodFill(image, sr, sc, color)));
    }

    @Test
    public void testcase2() {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int[][] expected = {{0, 0, 0}, {0, 0, 0}};
        int sr = 0, sc = 0, color = 0;
        assertTrue(is2dArrEq(expected, createSolutionProvider().floodFill(image, sr, sc, color)));
    }

    private boolean is2dArrEq(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        if (a.length > 0) {
            int l = a[0].length;
            int h = a.length;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (a[i][j] != b[i][j]) return false;
                }
            }
        }
        return true;
    }
}
