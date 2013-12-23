import java.util.Arrays;
import java.util.Scanner;



/**
 * DP  longest path of DAG
 * Stacking Boxes
 */

public class UVa103 {
	public static int k;
	public static int n;
	public static int[] d; 
	public static int[][] boxes;
	public static int[][] graph;

	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		
		while(cin.hasNextInt()){
			k = cin.nextInt();
			n = cin.nextInt();
			d = new int[k];
			boxes = new int[k][n];
			graph = new int[k][k];
			int rst = -1;
			int index = 0;
			
			for(int i=0; i<k; i++)
				for(int j=0; j<n; j++)
					boxes[i][j] = cin.nextInt();
			
			for(int i=0; i<k; i++)
				Arrays.sort(boxes[i]);
			
			getGraph();
			
			for(int i=0; i<k; i++){
				d[i] = dp(i);
				if(d[i] > rst){
					rst = d[i];
					index = i;
				}
			}
			
			System.out.println(rst);
			System.out.print((index+1) + " ");
			while(--rst > 0){
				for(int j=0; j<k; j++)
					if(graph[index][j] > 0 && d[j] == rst){
						System.out.print((j+1) +" ");
						index = j;
						break;
					}
			}
			System.out.println();
		}
		
		cin.close();
	}
	
	public static void getGraph(){
		for(int i=0; i<k; i++)
			for(int j=0; j<k; j++){
				graph[i][j] = 1;
				for(int m=0; m<n; m++)
					if(boxes[i][m] >= boxes[j][m]){
						graph[i][j] = 0;
						break;
					}
			}
	}
	
	public static int dp(int i){
		int ans = 1;
		
		if(d[i] > 0)
			return d[i];
		
		for(int j=0; j<k; j++)
			if(graph[i][j] > 0){
				int temp = dp(j) + 1;
				if(temp > ans)
					ans = temp;
			}
		d[i] = ans;
		return ans;
	}
	
			
}
