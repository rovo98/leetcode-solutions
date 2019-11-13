/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// recursion way.
func preorderTraversal(root *TreeNode) []int {
    res := make([]int, 0)
    helper(root, &res)
    return res
}
func helper(root *TreeNode, res *[]int) {
    if root == nil {
        return
    }
    *res = append(*res, root.Val)
    helper(root.Left, res)
    helper(root.Right, res)
}
