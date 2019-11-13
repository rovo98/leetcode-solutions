# 0217. Contains Duplicate

## Description

Given an array of integers, find if the array contains any duplicates.

Your function should return ``true`` if any value appears at least twice in the array, and it should return ``false`` 
if every element is distinct.

**Example 1:**
```txt
Input: [1,2,3,1]
Output: true
```
**Example 2:**

```txt
Input: [1,2,3,4]
Output: false
```
**Example 3:**

```txt
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```
 
**Links**

[(en)https://leetcode.com/problems/contains-duplicate/](https://leetcode.com/problems/contains-duplicate/)
<br />
[(中文)https://leetcode-cn.com/problems/contains-duplicate/](https://leetcode-cn.com/problems/contains-duplicate/)

## Solutions

判断一个数组中是否存在重复的元素，最直接的方式，可以使用暴力法 (brute-force) 来解决，两层循环遍历即可。

### Solution1

```java
/*
   brute-force approach
   Complexity Analysis:
   Time complexity: O(n^2)
   Space complexity: O(1)
   */
public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] == nums[j])
                return true;
        }
    }
    return false;

}
```

**Submission status**

时间复杂度为 $O(n^2)$, 提交的代码的运行时间为 433 ms。

#### Solution 2

利用 ``HashSet`` 集合的特性来处理。

```txt
/*
   one iteration(using hashSet) approach
   Complexity Analysis:
   Time complexity: O(n)
   Space complexity: O(n)
   */
public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i]))
            return true;
        set.add(nums[i]);
    }
    return false;
}
```

**Submission status**

运行时间 8 ms, 击败 58.3%。

#### Soluton 3

可以使用 $O(n log n)$ 的排序算法先对输入的数组进行排序，然后进行一趟遍历，判断当前元素是否与下一个元素相同即可。

```java
/*
one iteration(sorting the given array) approach
Complexity Analysis:
    Time complexity: O(n log n)
    Space complexity: O(1)
*/
public boolean containsDuplicate(int[] nums) {
    if (nums.length <= 1) return false;
    
    Arrays.sort(nums);
    for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1])
                return true;
    }
    return false;
}
```
