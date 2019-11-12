# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# iterative way using a stack.


class Solution:
    def preorderTraversal(self, root):
        res = []
        if root is None:
            return res
        stack = []
        stack.append(root)
        while len(stack) > 0:
            poped = stack.pop()
            res.append(poped.val)
            if poped.right is not None:
                stack.append(poped.right)
            if poped.left is not None:
                stack.append(poped.left)
