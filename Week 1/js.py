def linear_search(arr, key, first, last, comps):
	print("Performing linear search")
	for i in range(first, last):
		comps += 1
		if(key == arr[i]):
			return comps, i, True
	return comps, None, False
	
def jump_search(arr, key):
	print(f"Searching for {key}:")
	n = len(arr)
	step_size = int(n**0.5)
	curr = 0
	prev = 0
	comps = 0
	while curr < n and arr[curr] < key:
		comps += 1
		print(f"current index = {curr}")
		prev = curr
		curr += step_size
	
	return linear_search(arr, key, prev, n, comps)

tests = int(input("Enter the number of test cases:"))
tc = 0
while tests > 0:
	num = int(input("Enter array size -->"))
	arr = []
	for i in range(num):
		arr.append(int(input(f"Enter element {i} -->")))
	key = int(input("Enter the value you wish to find -->"))
	tc += 1
	comps, index, found = jump_search(arr, key)
	if found:
		print(f"Value found at index {index}\nTest = {tc}\ncomparisons = {comps}")
	else:
		print(f"Value not found!")
	
	print(f"Test = {tc}\ncomparisons = {comps}")
	tests -= 1
	arr.clear()
