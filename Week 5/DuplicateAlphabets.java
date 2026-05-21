import java.util.*;
class Result{
	int max = 0;
	int index = -1;
}
public class DuplicateAlphabets{
	public static Result dupAlpha(char[] arr){
		Result res = new Result();
		int[] freq = new int[26];
		int v;
		for(int i = 0; i< arr.length ; i++){
			if(arr[i] >= 'a' && arr[i] <= 'z'){
				v = arr[i] - 'a';
			} else if(arr[i] >= 'A' && arr[i] <= 'Z'){
				v = arr[i] - 'A';
			} else {
				continue;
			}
			freq[v]++;
		}
		res.max = 0;
		res.index = -1;

		for(int i = 0; i < 26; i++){
			if(freq[i] > res.max){
				res.max = freq[i];
				res.index = i;
			}
		}

		return res;
		
	}

	public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of test cases: ");
    int t = sc.nextInt();

    while(t-- > 0){

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        char[] arr = new char[n];
        if(n < 2){
        	System.out.println("No Duplicates Present");
        	continue;
        }
        System.out.println("Enter characters:");

        for(int i = 0; i < n; i++){
            arr[i] = sc.next().charAt(0);
        }

        Result res = dupAlpha(arr);

        if(res.max == 1){
            System.out.println("No Duplicates Present");
        } else {
            System.out.println((char)(res.index + 'a') + " - " + res.max);
        }

        System.out.println();
    }

    sc.close();
}
}