import java.util.Scanner;


public class POJ2533 {

	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] num = new int[n];
		int[] lis = new int[n];
		int ans = 1;
		
		for(int i=0; i<n; i++)
			num[i] = cin.nextInt();
		
		lis[0] = 1;
		for(int i=1; i<n; i++){
			lis[i] = 1;
			for(int j=0; j<i;j++){
				if(num[i] > num[j]){
					lis[i] = Math.max(lis[i], lis[j]+1);
					ans = Math.max(ans, lis[i]);
				}
			}
		}
		
		System.out.println(ans);
		cin.close();
	}
	
}
