package graphsPartOne.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeCycyle {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//***********************************************************************************
	public static int solve(boolean[][] graph, int n) {
		/*
		 * Your class should be named Solution 
		 * You may write your code here
		 */
//		for(int i=0;i<graph.length;i++){
//			 for(int j=0;j<graph[0].length;j++){
//				 System.out.print(graph[i][j]+" ");
//			 }
//			 System.out.println();
//		 }
		int count=0;
		boolean visited[]=new boolean[graph.length];
		
		for(int i=0;i<visited.length;i++) {
			int output=helper(graph, i, i, visited, 3);
			count=count+output;
		}
		return count/6;
	}
	
	public static int helper(boolean graph[][], int vertex, int original, boolean visited[], int cycle) {
		//System.out.println("Vertex-"+vertex+" Original-"+original+" Cycle-"+cycle);
		if(cycle==1) {
			if(graph[vertex][original]==true ) {
				//System.out.println("Vertex-"+vertex+" Original-"+original);
				return 1;
			}else {
				return 0;
			}
		}
		
		visited[vertex]=true;
		cycle=cycle-1;
		int count=0;
		for(int i=0;i<graph.length;i++) {
			if(graph[vertex][i]==true && visited[i]==false) {
				int output=helper(graph, i, original, visited, cycle);
				count=count+output;
			}
		}
		visited[vertex]=false;
		return count;
	}
	//**********************************************************************
	public static boolean[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int m = Integer.parseInt(strNums[1]);

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}
}