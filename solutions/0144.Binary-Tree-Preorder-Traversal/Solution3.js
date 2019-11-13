
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
// iterative approach without using any stacks.
let preorderTraversal = function (root) {
  let res = []
  if (root === null) return res
  let curr = root
  let pre = null
  while (curr !== null) {
    res.push(curr.val)
    // if curr.left == null, navigate its right child.
    if (curr.left == null) { curr = curr.right } else {
      // if curr.right is not null, make it as the right child of the rightmost child of curr's left child.
      if (curr.right !== null) {
        pre = curr.left
        while (pre.right !== null) { pre = pre.right }
        pre.right = curr.right
        curr.right = null
      }
      // navigate to curr's left child.
      curr = curr.left
    }
  }
}
