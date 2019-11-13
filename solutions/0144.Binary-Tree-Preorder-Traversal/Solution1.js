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
// recursion way.
let preorderTraversal = function (root) {
  let res = []
  helper(root, res)
  return res
}
function helper (root, res) {
  if (root === null) return
  res.push(root.val)
  helper(root.left, res)
  helper(root.right, res)
}
