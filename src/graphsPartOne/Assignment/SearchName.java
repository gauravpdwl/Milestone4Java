package graphsPartOne.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SearchName {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }


		String[] Graph = new String[input[0]];
		
        for (int i = 0; i < input[0]; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] Graph = takeInput();
        System.out.println(new Solution1().solve(Graph,Graph.length,Graph[0].length()));


    }
    
}

class Solution1 {
	
	public int helper(String graph[], int n, int m, int r, int c, boolean visited[][], String rem) {
		
		if(rem.length()==0) {
			return 1;
		}
		
		if(r<0 || r>=n || c<0 || c>=m) {
			return 0;
		}
		
		visited[r][c]=true;
		
		if(graph[r].charAt(c)==rem.charAt(0) && visited[r][c]==false) {
			//System.out.println("r-"+r+" c-"+c);
			//top
			if(helper(graph, n, m, r-1, c, visited, rem.substring(1))==1) {
				return 1;
			}
			//right-top
			if(helper(graph, n, m, r-1, c+1, visited, rem.substring(1))==1) {
				return 1;
			}
			//right
			if(helper(graph, n, m, r, c+1, visited, rem.substring(1))==1) {
				return 1;
			}
			//bottom-right
			if(helper(graph, n, m, r+1, c+1, visited, rem.substring(1))==1) {
				return 1;
			}
			//bottom
			if(helper(graph, n, m, r+1, c, visited, rem.substring(1))==1) {
				return 1;
			}
			//bottom-left
			if(helper(graph, n, m, r+1, c-1, visited, rem.substring(1))==1) {
				return 1;
			}
			//left
			if(helper(graph, n, m, r, c-1, visited, rem.substring(1))==1) {
				return 1;
			}
			//left-top
			if(helper(graph, n, m, r-1, c-1, visited, rem.substring(1))==1) {
				return 1;
			}
		}
		visited[r][c]=false;
		return 0;
	}
	
	public int solve(String[] Graph , int N, int M)
	{
		int r=0;
		int c=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(Graph[i].charAt(j)=='C') {
					r=i;
					c=j;
				}
			}
		}
		
		if(Graph[r].charAt(c)!='C') {
			return 0;
		}
		
		boolean visited[][]=new boolean[N][M];
		
		int output=helper(Graph, N, M, r, c, visited, "CODINGNINJA");
		return output;
	}
	
	
}

