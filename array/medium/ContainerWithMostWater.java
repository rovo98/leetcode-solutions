package Array.Medium;


/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @author rovo98
 * date: 2018.11.27 09:34
 */
public class ContainerWithMostWater {
    /**
     * private empty constructor
     * <p>
     * this class can not be instanced.
     */
    private ContainerWithMostWater() {
    }

    /*
    BruteForce approach:
        Complexity Analysis:
           Time complexity: O(n^2)
           Space complexity: O(1)
     */
    public static int maxAreaBruteForce(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
                if (temp > maxArea)
                    maxArea = temp;
            }
        }

        return maxArea;
    }

    /*
    Two Pointers approach:
        Complexity Analysis:
            Time complexity: O(n)
            Space complexity: O(1)
     */
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        /*
        while (i < j) {
            maxArea = Math.max(maxArea, height[i]<height[j]?(j-i)*height[i]:(j-i)*height[j]);
            if (height[j]<height[i]) {
                j--;
            } else {
                i++;
            }
        }
         */
        while (i < j)
            maxArea = Math.max(maxArea, height[i] < height[j] ? (j - i) * height[i++] : (j - i) * height[j--]);

        return maxArea;
    }

    /**
     * Driver the program to test the methods above.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("The input test case is the following:");
        for (int e : test) {
            System.out.print(e + ",");
        }
        System.out.println("\nAnd result(Brute-force) is " + maxAreaBruteForce(test) + ".");
        System.out.println("The result(Two pointers) is " + maxArea(test) + ".");
    }
}
