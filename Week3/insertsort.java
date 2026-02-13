import java.util.*;
class insertsort{
	static class Result{
	int comparisons;
	int shifts;
	}

	static Result insertionSort(int[] arr){
		Result res = new Result();
		int n = arr.length;

		for(int i = 1, i < n; i++){
			int key = arr[i];
			int j = i-1;

			while(j >= 0){
				res.comparisons++;
				if(arr[j] > key){
					arr[j + 1] = arr[j];
					res.shifts++;
					j--;
				} else {
					break;
				}
			}
			arr[j + 1] = key;
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

            Result res = insertionSort(arr);

            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("comparisons = " + res.comparisons);
            System.out.println("shifts = " + res.shifts);
            t--;
        }
        sc.close();
    }
}