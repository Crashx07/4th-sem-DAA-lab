import java.util.*;

class KSmallestRandom{
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int quick_select(int[] arr, int low, int high, int k){
		if(low <= high){
			if(low == high){
				return arr[low];
			}

			int pi = partition(arr, low, high);
			
			if(pi > k){
				return quick_select(arr, low, pi-1, k);
			} else if(pi < k){
				return quick_select(arr, pi + 1, high, k);
			} else {
				return arr[pi];
			}
		}

		return -1;
	}

	private static int partition(int[] arr, int low, int high){
		Random rand = new Random();
		int pivotIndex = low + rand.nextInt(high - low + 1);
		swap(arr, pivotIndex, high);
		
		int pivot = arr[high];
		int i = (low - 1);

		for(int j = low; j < high; j++){
			if(arr[j] <= pivot){
				i++;
				swap(arr, i, j); 
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array Size:");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			System.out.print(i + ":");
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter K:");
		int k = sc.nextInt();

		int k_smallest = quick_select(arr, 0, arr.length - 1, k);
		if(k_smallest != -1){
			System.out.println("Kth Smallest = " + k_smallest);
		}  else {
			System.out.println("Value of K is greater than size of array!");
		}
	}
}