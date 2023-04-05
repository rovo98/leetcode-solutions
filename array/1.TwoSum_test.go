package leetcode

import (
	"testing"

	"github.com/rovo98/leetcode-solutions/utils"
)

type input struct {
	nums   []int
	target int
}

func TestTwoSum(t *testing.T) {
	testcases := []struct {
		in   input
		want []int
	}{
		// case 1
		{
			input{
				[]int{2, 7, 11, 15},
				9,
			},
			[]int{0, 1},
		},
		// case 2
		{
			input{
				[]int{3, 2, 4},
				6,
			},
			[]int{1, 2},
		},
		// case 3
		{
			input{
				[]int{3, 3},
				6,
			},
			[]int{0, 1},
		},
	}

	for _, tc := range testcases {
		res := twoSum(tc.in.nums, tc.in.target)

		same := utils.IsTwoSliceSame(res, tc.want)

		if !same {
			t.Errorf("twoSum-> nums: %v, target: %v, want: %v.\n",
				tc.in.nums, tc.in.target, tc.want)
		}
	}
}
