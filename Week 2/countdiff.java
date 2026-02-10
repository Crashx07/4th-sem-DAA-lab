static int count_difference(int[] arr, int k){
	Arrays.sort(arr);
	int i = 0;
	int j = 1;
	int count = 0;
	int n = arr.length;
	while(i < n && j < n){
		if(i == j)
		{
			j++;
			continue;
		}
		if((arr[j] - arr[i]) > k){
			i++;
		} else if((arr[j] - arr[i]) < k){
			j++;
		} else {
			count++;
			j++;
			i++;
		}
	}
	return count;
}
