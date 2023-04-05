package utils

import "testing"

type slices struct {
	s1 []int
	s2 []int
}

func TestIsTwoSliceSame(t *testing.T) {
	testcases := []struct {
		in   slices
		want bool
	}{
		{
			slices{
				[]int{0},
				[]int{0},
			},
			true,
		},

		{
			slices{
				[]int{0, 1},
				[]int{0},
			},
			false,
		},
	}

	for _, tc := range testcases {
		got := IsTwoSliceSame(tc.in.s1, tc.in.s2)
		if got != tc.want {
			t.Fatalf("IsTwoSliceSame: s1: %v, s2: %v, want: %v.\n",
				tc.in.s1, tc.in.s2, tc.want)
		}
	}
}
