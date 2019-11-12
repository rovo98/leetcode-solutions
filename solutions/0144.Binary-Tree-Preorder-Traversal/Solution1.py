# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# recursive way.


class Solution:
    def __init__(self):
        self.res = []

    def preorderTraversal(self, root):
        self.helper(root, self.res)
        return self.res

    def helper(self, root, result):
        if root is None:
            return
        self.res.append(root.val)
        self.helper(root.left, self.res)
        self.helper(root.right, self.res)
