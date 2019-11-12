/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// iterative way using a stack.
let preorderTraversal = function (root) {
  let res = []
  if (root === null) return res
  let stack = []
  stack.push(root)
  let poped = null
  while (stack.length > 0) {
    poped = stack.pop()
    res.push(poped.val)
    if (poped.right != null) { stack.push(poped.right) }
    if (poped.left != null) { stack.push(poped.left) }
  }
  return res
}
