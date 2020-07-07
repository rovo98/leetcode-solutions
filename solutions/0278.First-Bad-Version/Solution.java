/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // using binary search
        int l = 1, r = n;
        int firstBadVer = Integer.MAX_VALUE; 
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                if (firstBadVer > m) 
                    firstBadVer = m;
                r = m - 3;
            }
            else
                l = m + 1;
        }
        return firstBadVer;
    }
}
