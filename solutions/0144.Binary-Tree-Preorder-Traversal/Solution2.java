class Solution {
    /**
      preOrder traversal iteration way using a stack.
      */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode poped = null;
        while (!stack.isEmpty()) {
            poped = stack.pop();
            result.add(poped.val);
            if (poped.right != null)
                stack.push(poped.right);
            if (poped.left != null)
                stack.push(poped.left);
        }
        return result;
    }
}
