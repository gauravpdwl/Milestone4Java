package graphsPartOne;
import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDFS {
	
	public static ArrayList<Integer> getPath(int graph[][],boolean visited[], int s, int e){
		if(s==e) {
			ArrayList<Integer> list=new ArrayList<>();
			list.add(e);
			return list;
		}
		
		visited[s]=true;
		for(int i=0;i<graph.length;i++) {
			if(graph[s][i]==1 && visited[i]==false) {
				ArrayList<Integer> out=getPath(graph, visited, i, e);
				if(out!=null && out.get(0)==e) {
					if(i!=e) {
						out.add(i);
					}
					return out;
				}
				return out;
			}
		}
		
//		ArrayList<Integer> list=new ArrayList<>();
//		list.add(s);
		return null; 
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
		
		if(start==0 && end==0){
			System.out.print(0+" ");

			return;
		}
		
//		System.out.println();
//		System.out.println("Adjacency Matrix");
//		for(int i=0;i<r_vertices;i++) {
//			for(int j=0;j<r_vertices;j++) {
//				System.out.print(am[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		boolean visited[]=new boolean[r_vertices];

//		System.out.println();
//		System.out.println("Get Path");
//		System.out.println();
		
		ArrayList<Integer> output=getPath(am, visited, start, end);
		
		if(output!=null && output.get(0)==end) {
			output.add(start);
			for(int i=0;i<output.size();i++) {
				System.out.print(output.get(i)+" ");
			}
				
		}
		
//		System.out.println(output.get(0));
	}
}
