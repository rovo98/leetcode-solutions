class Solution {
    /*
    Approach One: using the idea of quickSort to sort the given array {@code points} firstly.
    Complexity Analysis:
    TC: O(n log n)
    SC: O(1)
    */
    public int[][] kClosest(int[][] points, int K) {
        if (K >= points.length)     return points; 
        
        int[][] result = new int[K][2];
         // using the idea of quickSort to sort the points firstly.
        quickSort(points);
        
        // returns the first K points.in the array
        for (int i = 0; i < K; i++) {
            result[i] = points[i];
        }
        return result;
    }
    // compare the distance of two points.
    private int compare(int[] distance, int i, int j) {
            if      (distance[i] > distance[j])     return 1;
            else if (distance[i] < distance[j])     return -1;
            else                                    return 0;
    }
    // quickSort for this problem
    private void quickSort(int[][] points) {
         // improvement one: compute the distance of all points and store in a array.
        int[] distance = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distance[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }
        sort(points, 0, points.length-1, distance);
    }
    // a simple implementation of quickSort algorithm.
    private void sort(int[][] points, int lo, int hi, int[] distance) {
        if (lo >= hi)       return;     // if only one element left.
        int povit = lo;
        int l = lo;
        int h = hi + 1;
        while (true) {
            while ( compare(distance, povit, ++l) > 0) {
                if (l == hi) break;
            }
            while ( compare(distance, povit, --h) < 0) {
                if ( h == lo) break;
            }
            if (l >= h) break;
            swap(points, distance, l, h);
        }
        swap(points, distance, lo, h);
        sort(points, lo, h-1, distance);
        sort(points, h+1, hi, distance);
    }
    // swap two points and their distance.
    private void swap(int[][] points, int[] distance, int i, int j) {
        // swap two points.
        int[] temp = points[i];
        points[i] = points[j];
        points[j]  = temp;
        // swap their distance.
        int dis = distance[i];
        distance[i] = distance[j];
        distance[j] = dis;
    }
}
