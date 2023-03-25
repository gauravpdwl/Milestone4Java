package graphsPartOne.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class ConnectingDots {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");

        int N = Integer.parseInt(strNums[0]);
        int M = Integer.parseInt(strNums[1]);

		String[] Graph = new String[N];
		
        for (int i = 0; i < N; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] Graph = takeInput();
        if (new Solution2().solve(Graph,Graph.length,Graph[0].length())==1){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }


    }
}


class Solution2 {

    public int solve(String[] board , int n, int m)
	{
		
    	boolean visited[][]=new boolean[n][m];
    	HashMap<Character, Integer> map=new HashMap<>();
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(!visited[i][j]) {
    				int output=helper(board, n, m, i, j, visited, board[i].charAt(j), i, j, 0);
    				if(map.get(board[i].charAt(j))!=null) {
    					if(map.get(board[i].charAt(j))<output) {
    						map.put(board[i].charAt(j), output);
    					}
    				}
    				else {
    					map.put(board[i].charAt(j), output);
    				}
    			}
    		}
    	}
    	
    	int max=Integer.MIN_VALUE;
    	
//    	for (char name : map.keySet()) 
//            System.out.println("key: " + name);
//          
        // using values() for iteration over values
        for (int values : map.values()) {
        	if(max<values) {
        		max=values;
        	}
        	//System.out.println("key: " + values);
        }
    	if(max>=4) {
    		return 1;
    	}else {
    		return 0;
    	}
		
	}
    
    public int helper(String graph[], int n, int m, int i, int j, boolean visited[][], char Vertex, int vrs, int vcs, int count) {
    	
    	if(i<0 || i>=n || j<0 || j>=m) {
    		return 0;
    	}
    	
    	if(i==vrs && j==vcs && visited[i][j]==true) {
    		//System.out.println("END i-"+i+" j-"+j);
    		return count;
    	}
    	
    	if(graph[i].charAt(j)!=Vertex) {
    		return 0;
    	}
    	
    	if(graph[i].charAt(j)==Vertex && visited[i][j]==false) {
    		visited[i][j]=true;
    		//System.out.println("i-"+i+" j-"+j);
    		int top=helper(graph, n, m, i-1, j, visited, Vertex, vrs, vcs, count+1);
    		int right=helper(graph, n, m, i, j+1, visited, Vertex, vrs, vcs, count+1);
    	    int bottom=helper(graph, n, m, i+1, j, visited, Vertex, vrs, vcs, count+1);
    	    int left=helper(graph, n, m, i, j-1, visited, Vertex, vrs, vcs, count+1);
    		
    	    int output=Math.max(top, Math.max(right, Math.max(left, bottom)));
    	    visited[i][j]=false;
    		return output;
    	}
    	
    	return 0;
    }
	
	
}