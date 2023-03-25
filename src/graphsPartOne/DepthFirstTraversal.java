package graphsPartOne;

import java.util.Scanner;

/*
Input-
4 3
0 1
0 3
1 2

Output-

0 1 0 1 
1 0 1 0 
0 1 0 0 
1 0 0 0 

Depth First Traversal 

0 1 2 3 */

public class DepthFirstTraversal {
	
	public static void depthFirstTraversal(int [][]graph, int currentVertex, boolean visited[]) {
		visited[currentVertex]=true;
		System.out.print(currentVertex+" ");
		for(int i=0;i<graph.length;i++) {
			if(graph[currentVertex][i]==1 && visited[i]==false) {
				depthFirstTraversal(graph, i, visited);
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int r_vertices=sc.nextInt();
		int c_edges=sc.nextInt();
		
		int am[][]=new int[r_vertices][r_vertices];
		
		for(int i=0;i<c_edges;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			am[v1][v2]=1;
			am[v2][v1]=1;
		}
			
		System.out.println();
		
		for(int i=0;i<r_vertices;i++) {
			for(int j=0;j<r_vertices;j++) {
				System.out.print(am[i][j]+" ");
			}
			System.out.println();
		}
		
		boolean visited[]=new boolean[r_vertices];
		System.out.println();
		System.out.println("Depth First Traversal ");
		System.out.println();
		depthFirstTraversal(am, 0, visited);
		
	}
}
