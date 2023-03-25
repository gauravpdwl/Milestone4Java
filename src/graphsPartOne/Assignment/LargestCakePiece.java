package graphsPartOne.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestCakePiece {
	
	/*
	 *
	 
	 Input-
	 3 
	 1 1 1 
	 0 1 0 
	 0 1 0 
	 
	 Output-
	 5
	 */
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        

        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = Solution3.dfs(edge,edge.length);
        System.out.println(ans);   
    }	
}

class Solution3 {

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int dfs(String[] edge, int n) {
		
		boolean visited[][]=new boolean[n][n];
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					int output=helper(edge, i, j, visited, 0);
					if(max<output) {
						max=output;
					}
				}
			}
		}
		
		return max;
	}
	
	public static int helper(String graph[], int i, int j, boolean visited[][], int count ) {
		
		int n=graph.length;
		if(i<0 || i>=n || j<0 || j>=n) {
			return 0;
		}
		
		if(graph[i].charAt(j)!='1') {
			return 0;
		}
		
		if(graph[i].charAt(j)=='1' &&  visited[i][j]==false) {
			visited[i][j]=true;
			count=count+1;
//			System.out.println("i-"+i+" j-"+j);
			int top=helper(graph, i-1, j, visited, count);
			int right=helper(graph, i, j+1, visited, count);
			int bottom=helper(graph, i+1, j, visited, count);
			int left=helper(graph, i, j-1, visited, count);
			
			int output=1+top+right+bottom+left;
			return output;
		}
		
		return 0;
		
	}


}