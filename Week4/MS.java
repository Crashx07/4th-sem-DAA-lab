import java.util.*;

class MS{
	static class Result{
		int comparisons;
		int inversions;
	}

	static Result mergeSort(int[] arr, int left, int right){
		Result res = new Result();
		if(left >= right){
			return res;
		}
		int mid = left + (right - left)/2;
		Result leftRes = mergeSort(arr, left, mid);// THIS returns a result. Are we not supposed to have an object here?
		Result rightRes = mergeSort(arr, mid+1, right);
		Result mergeRes = merge(arr, left, mid, right);

		res.comparisons += leftRes.comparisons + rightRes.comparisons + mergeRes.comparisons;
		res.inversions += leftRes.inversions + rightRes.inversions + mergeRes.comparisons;

		return res;
	}

	static Result merge(int[] arr, int left, int mid, int right){
		Result res = new Result();
		int leftsize = mid - left + 1;
		int rightsize = right - mid;
		int[] leftArr = new int[leftsize];
		int[] rightArr = new int[rightsize];

		for(int i = 0; i < leftsize; i++){
			leftArr[i] = arr[left + i];
		}

		for(int j = 0; j < rightsize; j++){
			rightArr[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		while(i < leftsize && j < rightsize){
			res.comparisons++;
			if(leftArr[i] <= rightArr[j]){
				arr[k] = leftArr[i];
				i++;
			} else {
				res.inversions += (leftsize - i);
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i < leftsize){
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while(j < rightsize){
			arr[k] = rightArr[j];
			j++;
			k++;
		}
		return res;
	}

	public static void main(String[] args){

	    int[] arr = {8,3,5,2};

	    Result r = mergeSort(arr,0,arr.length-1);

	    for(int x : arr)
	        System.out.print(x + " ");

	    System.out.println("\ncomparisons = " + r.comparisons);
		System.out.println("inversions = " + r.inversions);

	}
}