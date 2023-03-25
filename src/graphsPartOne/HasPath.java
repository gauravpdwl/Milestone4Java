package graphsPartOne;
import java.util.Scanner;

public class HasPath {
	
	public static boolean hasPath(int graph[][], boolean visited[], int s, int e) {
		
		if(s==e) {
			return true;
		}
		
		visited[s]=true;
		for(int i=0;i<graph.length;i++) {
			if(graph[s][i]==1 && visited[i]==false) {
				boolean output=hasPath(graph, visited, i, e);
				if(output==true) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int r_vertices=sc.nextInt();
		int c_edges=sc.nextInt();
		
		if(r_vertices==0 && c_edges==0){
			return;
		}

		if(c_edges==0 && r_vertices>0){
			for(int i=0;i<r_vertices;i++){
				System.out.print(i+" ");
			}
			return;
		}

		if(r_vertices==0){
			//System.out.println(0);
			return;
		}
		
		int am[][]=new int[r_vertices][r_vertices];
		
		for(int i=0;i<c_edges;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			am[v1][v2]=1;
			am[v2][v1]=1;
		}
		
		int start=sc.nextInt();
		int end=sc.nextInt();
		
		System.out.println();
		System.out.println("Adjacency Matrix");
		for(int i=0;i<r_vertices;i++) {
			for(int j=0;j<r_vertices;j++) {
				System.out.print(am[i][j]+" ");
			}
			System.out.println();
		}
		
		boolean visited[]=new boolean[r_vertices];

		System.out.println();
		System.out.println("Has Path?");
		System.out.println();
		
		boolean output=hasPath(am, visited, start, end);
		System.out.println("Has Path - " +output);
		
	}
}
