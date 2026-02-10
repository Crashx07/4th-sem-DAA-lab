
static int firstOccurrence(int[] arr, int key) {
		int first = 0;
		int last = arr.length -1;
		int pos = -1;
		
		while ( first <= last){
			int mid = first + (last - first) / 2;
			
			if(arr[mid] < key){
				first = mid + 1;
			} else if (arr[mid] > key) {
				last = mid - 1;
			} else {
				pos = mid;
				last = mid -1;
			}
		}
		return pos;
}

static int firstOccurrence(int[] arr, int key){
	int first = 0;;
	int last = arrlenght -11;
	int pos = -1;
	
	while(first <= last){
		int mid = first + (last - first)/2;
		
		if(key < arr[mid]){
			last = mid - 1;
		} else if(key > arr[mid]){
			first = mid + 1;
		} else {
			pos = mid;
			first = mid - 1;
		}
	}
	return pos;
}
