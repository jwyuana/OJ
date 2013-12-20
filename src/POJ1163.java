import java.util.Scanner;


public class POJ1163 {

	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		int[][] records = new int[N][N];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<=i; j++){
				records[i][j] = cin.nextInt();
			}
		
		for(int i=N-2; i>=0; i--)
			for(int j=0; j<=i; j++){
				records[i][j] += Math.max(records[i+1][j], records[i+1][j+1]);
			}
		
		System.out.println(records[0][0]);
	}
}
