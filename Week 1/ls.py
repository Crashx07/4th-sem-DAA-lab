#linear search.
#given an array Arr[n], and key (value to be found)

def ls(arr, key):
	comps = 0
	for i in range(len(arr)):
		comps += 1
		if(key == arr[i]):
			return comps, i, True
	return comps, None, False

tests = int(input("Enter the number of test cases:"))
tc = 0
while tests > 0:
	num = int(input("Enter array size -->"))
	arr = []
	for i in range(num):
		arr.append(int(input(f"Enter element {i} -->")))
	key = int(input("Enter the value you wish to find -->"))
	tc += 1
	comps, index, found = ls(arr, key)
	if found:
		print(f"Value found at index {index}\nTest = {tc}\ncomparisons = {comps}")
	else:
		print(f"Value not found!")
	
	print(f"Test = {tc}\ncomparisons = {comps}")
	tests -= 1
	arr.clear()
