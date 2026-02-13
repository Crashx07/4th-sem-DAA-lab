import java.util.*;
class selectsort{
	static class Result{
	int comparisons;
	int swaps;
	}

	static Result selectsort(int[] arr){
		Result res = new Result();
		int n = arr.length;
		int temp;
		for(int i = 0; i < n-1; i++){
			int min = i;
			for(int j = i+1; j < n; j++){
				res.comparisons++;
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			if(min != i){
				temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
				res.swaps++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Result res = selectsort(arr);

            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("comparisons = " + res.comparisons);
            System.out.println("swaps = " + res.swaps);
            t--;
        }
        sc.close();
    }
}