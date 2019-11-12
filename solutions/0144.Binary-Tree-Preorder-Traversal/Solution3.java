class Solution {
    /**
     * preorder traversal without using stacks.
     * Complexity Analysis: 
     *  Time complexity: O(n) while n is the number of the nodes in binary tree.
     *  Space complexity: O(1) if result array does not counts
     * */
    public List<Integer> preorderTraversal(TreeNode root) { 
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null) {
            res.add(curr.val);
            if (curr.left == null) {
                curr = curr.right;
            } else { // make curr's right childs as the right child of the rightmost chld of curr's left child
                pre = curr.left;
                if (curr.right != null) {
                    while (pre.right != null)
                        pre = pre.right;
                    pre.right = curr.right;
                    curr.right = null;
                }
                // navigate to curr's left child
                curr = curr.left;
            }
        }
    }
}
