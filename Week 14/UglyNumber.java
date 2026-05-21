import java.util.*;

public class UglyNumber{
	public static int uglyNumber(int n){
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		for(int i = 1; i < n; i++){
			int next2 = ugly[i2] * 2;
			int next3 = ugly[i3] * 3;
			int next5 = ugly[i5] * 5;

			ugly[i] = min(next2, min(next3,next5));
			
			if(ugly[i] == next2) i2++;
			if(ugly[i] == next3) i3++;
			if(ugly[i] == next5) i5++;
		}

		return ugly[n-1];
	}

	private static int min(int a, int b){
		return a < b? a:b;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(uglyNumber(n));
	}
}