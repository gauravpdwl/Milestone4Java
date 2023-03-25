package graphsPartOne;

import java.util.Scanner;

public class IsConnected {
	
	public static void isConnected(int graph[][], boolean visited[], int currentVertex) {
		
		visited[currentVertex]=true;
		for(int i=0;i<graph.length;i++) {
			if(graph[currentVertex][i]==1 && visited[i]==false) {
				isConnected(graph, visited, i);
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		/*
		 Input -
		 4 4 
		 0 1 
		 0 3 
		 1 2 
		 2 3
		 Output - 
		 true
		 */
		
		Scanner sc=new Scanner(System.in);
		int r_vertices=sc.nextInt();
		int c_edges=sc.nextInt();
		
		if(r_vertices==0 && c_edges==0){
			System.out.println(true);
			return;
		}

//		if(c_edges==0 && r_vertices>0){
//			for(int i=0;i<r_vertices;i++){
//				System.out.print(i+" ");
//			}
//			return;
//		}
//
//		if(r_vertices==0){
//			return;
//		}
		
		int am[][]=new int[r_vertices][r_vertices];
		
		for(int i=0;i<c_edges;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			am[v1][v2]=1;
			am[v2][v1]=1;
		}
		
		boolean visited[]=new boolean[r_vertices];
		
		isConnected(am, visited, 0);
		
		boolean output=true;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==false) {
				output=false;
			}
		}
		
		System.out.println(output);
	}
}
