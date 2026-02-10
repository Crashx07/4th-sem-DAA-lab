def swap(a, b):
	t = a
	a = b
	b = t
	return a, b
	

def insert_sort(arr):
	n = len(arr)
	
	for i in range(1, n):
		j = i-1
		val = arr[i]
		while j >= 0 and arr[j] > val:
			print(f"Comparing {arr[i]} and {val}")
			arr[j+1] = arr[j]
			j-=1
		print(f"{arr[j+1]} and {val}")
		arr[j+1] = val
	
	print(arr)

def selection_sort(arr):
	n = len(arr)
	for i in range(n):
		min = i
		for j in range(i+1,n):
			if arr[min] > arr[j]:
				min = j
		arr[min], arr[i] = swap(arr[min], arr[i])
	print(arr)
	

insert_sort([9,8,7,6,5,4,3,2,1,0])
selection_sort([9,8,7,6,5,4,3,2,1,0])
