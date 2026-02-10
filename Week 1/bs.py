def bs(arr, key):
	comps = 0
	first = 0
	last = len(arr)-1
	while(first <= last):
		n = (first + last)//2
		comps += 1
		if(arr[n] < key):
			first = n+1
		elif(arr[n] > key):
			last = n-1
		else:
			return comps, n, True
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
	comps, index, found = bs(arr, key)
	if found:
		print(f"Value found at index {index}\nTest = {tc}\ncomparisons = {comps}")
	else:
		print(f"Value not found!")
	
	print(f"Test = {tc}\ncomparisons = {comps}")
	tests -= 1
	arr.clear()
