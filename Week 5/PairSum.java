import java.util.*;

public class PairSum{
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void quickSort(int[] arr, int low, int high){
		if(low < high){
			int pi = partition(arr, low, high);

			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high){
		Random rand = new Random();
		int pivotIndex = low + rand.nextInt(high - low + 1);
		swap(arr, pivotIndex, high);

		int pivot = arr[high];
		int i = (low -1);

		for(int j = low; j < high; j++){
			if(arr[j] < pivot){
				i++;
				swap(arr, j, i);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}

	public static boolean pairSum(int[] arr, int key){
		quickSort(arr, 0, arr.length-1);
		int n =arr.length;
		int i = 0;
		int j = n-1;
		boolean found = false;
		while(i < j){
			if(i == j){
				return found;
			}

			if((arr[i] + arr[j]) > key){
				j--;
			} else if((arr[i] + arr[j]) < key){
				i++;
			} else {
				System.out.println(arr[i] + " " + arr[j]);
				i++;
				j--;
				found = true;
			}
		}
		return found;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			System.out.println("arr[" + i +"] = ");
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the key:");
		if(pairSum(arr, sc.nextInt())){
			System.out.println("Success");
		}else{
			System.out.println("No such pair exists!");
		}

		sc.close();

	}
}