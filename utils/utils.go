package utils

type Number interface {
	int | int8 | int16 | int32 | int64 | float32 | float64
}

type Elem interface {
	Number | string
}

// IsTwoSliceSame returns true if given two slices contains same elements.
// otherwise false
func IsTwoSliceSame[E Elem](s1 []E, s2 []E) bool {
	if len(s1) != len(s2) {
		return false
	}

	xMap := make(map[E]int)
	yMap := make(map[E]int)

	for _, xElem := range s1 {
		xMap[xElem]++
	}
	for _, yElem := range s2 {
		yMap[yElem]++
	}

	for xMapKey, xMapVal := range xMap {
		if yMap[xMapKey] != xMapVal {
			return false
		}
	}
	return true
}
