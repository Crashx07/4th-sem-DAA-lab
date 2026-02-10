def first_occurence(arr, key):
	last = len(arr)-1
	first = 0
	pos = -1
	while first <= last:
		mid = int((last - (last - first)/2))
		if key < arr[mid]:
			last = mid - 1
		elif key > arr[mid]:
			first = mid + 1
		else:
			pos = mid
			last = mid - 1
			
	return pos
			
def last_occurrence(arr, key):
	last = len(arr) - 1
	first = 0
	pos = -1
	while first <= last:
		mid = int(last - (last-first)/2)
		if key < arr[mid]:
			last = mid - 1
		elif key > arr[mid]:
			first = mid + 1
		else:
			pos = mid
			first = mid + 1
	return pos





