package graphsPartOne;

import java.util.Scanner;

public class GraphUsingAdjacencyMatrix {
	
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
		
		for(int i=0;i<r_vertices;i++) {
			for(int j=0;j<r_vertices;j++) {
				System.out.print(am[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
