def count_difference(arr, k):
	arr.sort()
	i = 0
	j = 1
	count = 0
	while i < len(arr) and j < len(arr):
		if i == j:
			j += 1
			continue
		if arr[j] - arr[i] > k:
			i += 1
		elif arr [j] - arr[i] < k:
			j += 1
		else:
			count += 1
			print(arr[i], arr[j])
			i += 1
			j += 1
	return count

print(count_difference([0,1,2,3,4,5,6,7,8,9,10,11,12], 0))
