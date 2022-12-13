package com.rovo98.leetcode.l75.day9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** https://leetcode.com/problems/flood-fill/description */
public class P733FloodFill {
    /*
    BFS approach (naive)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // base case
        if (image[sr][sc] == color) return image;

        Deque<Point> queue = new ArrayDeque<>();
        Set<Point> visited = new HashSet<>();

        queue.offer(new Point(sr, sc));
        int originalColor = image[sr][sc];
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            image[p.i][p.j] = color;
            helper(image, p.i, p.j, originalColor, queue, visited);
        }
        return image;
    }

    private void helper(
            int[][] image, int sr, int sc, int color, Deque<Point> queue, Set<Point> set) {

        int l = image[0].length;
        int h = image.length;

        // up
        if ((sr - 1) >= 0 && image[sr - 1][sc] == color) {
            Point np = new Point(sr - 1, sc);
            if (!set.contains(np)) {
                queue.offer(np);
            }
        }
        // down
        if ((sr + 1) < h && image[sr + 1][sc] == color) {
            Point np = new Point(sr + 1, sc);
            if (!set.contains(np)) {
                queue.offer(np);
            }
        }
        // left
        if ((sc - 1) >= 0 && image[sr][sc - 1] == color) {
            Point np = new Point(sr, sc - 1);
            if (!set.contains(np)) {
                queue.offer(np);
            }
        }
        // right
        if ((sc + 1) < l && image[sr][sc + 1] == color) {
            Point np = new Point(sr, sc + 1);
            if (!set.contains(np)) {
                queue.offer(np);
            }
        }
    }

    static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object p) {
            if (this == p) return true;
            if (!(p instanceof Point point)) return false;
            return this.i == point.i && this.j == point.j;
        }

        public int hashCode() {
            return Objects.hash(this.i, this.j);
        }
    }
}
