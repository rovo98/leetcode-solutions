# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# iterative way without using any stack.


class Solution:
    def preorderTraversal(self, root):
        res = []
        if root is None:
            return res

        curr = root
        while curr is not None:
            res.append(curr.val)
            if curr.left is None:
                curr = curr.right
            else:
                if curr.right is not None:
                    pre = curr.left
                    while pre.right is not None:
                        pre = pre.right
                    pre.right = curr.right
                    curr.right = None
                curr = curr.left
