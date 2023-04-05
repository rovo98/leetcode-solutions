package leetcode

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		remain := target - v
		j, ok := m[remain]
		if ok {
			return []int{i, j}
		}
		m[v] = i
	}

	// happy the compiler
	return []int{0}
}
