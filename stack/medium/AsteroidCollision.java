package Stack.Medium;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

/**
 * Problem: Acceptance: 37.4%
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid., the absolute value represents its size, and the sign represents its
 * direction (positive meaning right, negative meaning left). Each asteroid moves at the same
 * speed.
 *
 * Find out the state of the asteroids after all collision. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode. Two asteroids moving in the
 * same direction will never meet.
 *
 * Example 1:
 * Input: asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 *
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 *
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 *
 * Note:
 *   1. The length of asteroids will be at most 10000.
 *   2. Each asteroid will be non-zero integer in the range [-1000, 1000].
 *
 * @author rovo98
 * Date: 22/2/2018
 */
public class AsteroidCollision {
    // Solution one: ^
    /*
    Complexity Analysis:
        Time Complexity: O(n).
        Space Complexity: O(n).
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (sameDirection(asteroids[i], stack.peek())) { // If the top elem and collide are both at the same direction.
                stack.push(asteroids[i]);
            } else {
                // Otherwise.
                int pElem = asteroids[i];
                while (!sameDirection(pElem, stack.peek()) && !stack.isEmpty()) {
                    if (Math.abs(stack.peek()) < Math.abs(pElem)) {         // Exploding the top elem of stack, continue.
                        stack.pop();
                    } else if (Math.abs(stack.peek()) == Math.abs(pElem)) { // Exploding each other.
                        stack.pop();
                        break;
                    } else {                                                // Exploding the collide we met.
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            int[] result = new int[stack.size()];
            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * Returns true if {@code asteroidA} and {@code asteroidB} have the same direction.
     * @param asteroidA the integer representing one asteroid.
     * @param asteroidB the integer representing another asteroid.
     * @return      {@code true} if two asteroids have the same direction;
     *              {@code false} otherwise.
     */
    private boolean sameDirection(int asteroidA, int asteroidB) {
        if (asteroidA > 0 && asteroidB > 0) {
            return true;
        }
        else if (asteroidA < 0 && asteroidB < 0) {
            return true;
        }
        return false;
    }

    // Driver the program  to test the method above.
    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        int[] testAsteroids = {5, 10, -5};
        int[] testAsteroids_2 = {10, 2, -5};
        System.out.println("The input test asteroids array one is the following:");
        for (int asteroid : testAsteroids) {
            System.out.print(asteroid + " ");
        }
        System.out.println();
        int[] result = ac.asteroidCollision(testAsteroids);
        System.out.println("And the result of it is the following:");
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }

        System.out.println("The input test asteroids array two is the following:");
        for (int asteroid : testAsteroids_2) {
            System.out.print(asteroid + " ");
        }
        System.out.println();
        int[]  result_2 = ac.asteroidCollision(testAsteroids_2);
        System.out.println("And the result of it is the following:");
        if (result_2 != null) {
            for (int elem : result_2) {
                System.out.print(elem + " ");
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }
}
