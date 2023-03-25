package graphsPartOne.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Islands {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        int[][] edges = new int[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            edges[firstvertex][secondvertex] = 1;
            edges[secondvertex][firstvertex] = 1;
        }
        return edges;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [][]edges = takeInput();
        
        int ans = Solution.numConnected(edges, edges.length);
        System.out.println(ans);
		
	}
    
    public class Solution {
    	
    	public static void isConnected(int graph[][], boolean visited[], int currentVertex) {
    		
    		visited[currentVertex]=true;
    		for(int i=0;i<graph.length;i++) {
    			if(graph[currentVertex][i]==1 && visited[i]==false) {
    				isConnected(graph, visited, i);
    			}
    		}
    		
    	}

    	public static int numConnected(int[][] edges, int n) {
            
    		boolean visited[]=new boolean[edges.length];
    		int connectedGraph=0;
    		for(int i=0;i<visited.length;i++) {
    			if(!visited[i]) {
    				connectedGraph=connectedGraph+1;
    				isConnected(edges, visited, i);
    			}
    		}
    		
    		return connectedGraph;
    	}


    }
}