package Array.Easy;

/**
 * Problem : Acceptance: 32.2%
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted
 * array.
 *
 * Note :
 * You may assume that nums1 has enough space(size that is greater or equal to m + n) to
 * hold additional elements from nums2. The number of elements initialized in nums1 and nums2
 * are m and n respectively.
 *
 * @author rovo98
 * Date: 02/2/2018
 */
public class MergeSortedArray {
    // Solution one: ^
    // According to the note given by this problem. We can design an algorithm having a O(n^3)
    // time complexity and O(1) memory complexity.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Iterate all the elements in the nums2.
        for (int i=0; i<n; i++) {
            // Iterate the elements in the nums1 to find the right position to insert.
            for (int j=0; j<m; j++) {
                if (nums2[i] < nums1[j]) {
                    // move the elements before insert.
                    for (int k=j; k<m; k++) {
                        nums1[k+1] = nums1[k];
                    }
                    // insert the element.
                    nums1[j] = nums2[i];
                }
            }
            // If the insert element is bigger than all the elements in nums1.
            nums1[m++] = nums2[i];
        }
    }
    // Solution two: ^
    // It doesn't meet the require in the note.
    // This algorithm's time complexity is O(n) and its space complexity is O(n) too.
    public int[] mergeVersionTwo(int[] nums1, int m, int[] nums2, int n) {
        // Allocate a new array with (m+n) size to store the elements.
        int[] mergedArray = new int[m+n];

        int pIndex = 0;
        int qIndex = 0;
        int count = 0;
        while (pIndex < m && qIndex < n) {
            if (nums1[pIndex] > nums2[qIndex]) {
                mergedArray[count++] = nums2[qIndex++];
            } else {
                mergedArray[count++] = nums1[pIndex++];
            }
        }
        // If nums1 have elements left.
        while (pIndex < m) {
            mergedArray[count++] = nums1[pIndex++];
        }
        // If nums2 have elements left.
        while (qIndex < n) {
            mergedArray[count++] = nums2[qIndex++];
        }

        return mergedArray;
    }

    // Driver the program to test the methods above.
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] testArr1 = {1, 2, 3, 4, 0, 0, 0, 0, 0, 0};
        int[] testArr2 = {5, 6, 7, 8, 9, 10};

        System.out.println("The input arrays is the following:");
        for (int i=0; i<4; i++) {
            System.out.print(testArr1[i]+" ");
        }
        System.out.println();
        for (int i=0; i<testArr2.length; i++) {
            System.out.print(testArr2[i]+" ");
        }
        System.out.println();
        int[] mergedArr = msa.mergeVersionTwo(testArr1, 4, testArr2, testArr2.length);
        msa.merge(testArr1, 4, testArr2, testArr2.length);
        System.out.println("After calling the method with version one, the output is the following:");
        for (int i=0; i<testArr1.length; i++) {
            System.out.print(testArr1[i]+" ");
        }
        System.out.println("\nAfter calling the method with version two, the output is the following:");
        for (int i=0; i<mergedArr.length; i++) {
            System.out.print(mergedArr[i]+" ");
        }
        System.out.println();
    }
}
