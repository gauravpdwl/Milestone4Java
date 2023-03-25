package graphsPartOne;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

9 11
0 2
0 3
0 6
2 1
3 5 
6 7
1 4
5 8
5 7
3 4
6 5

Input-

8 7
0 1
0 3
0 5
1 2
1 4
3 7
5 6

Output-

0 1 0 1 0 1 0 0 
1 0 1 0 1 0 0 0 
0 1 0 0 0 0 0 0 
1 0 0 0 0 0 0 1 
0 1 0 0 0 0 0 0 
1 0 0 0 0 0 1 0 
0 0 0 0 0 1 0 0 
0 0 0 1 0 0 0 0 

Breadth First Traversal 

0 1 3 5 2 4 7 6 
 */
public class BreadthFirstTraversal {
	
	public static void breadthFirstTraversal(int graph[][], Queue<Integer> que, boolean visited[], boolean QPresent[]) {
		if(que.peek()==null) {
			//System.out.println(que.peek());
			return;
		}
		int currentVertex=que.poll();
		visited[currentVertex]=true;
		System.out.print(currentVertex+" ");
		for(int i=0;i<graph.length;i++) {
			if(graph[currentVertex][i]==1 && visited[i]==false) {
				if(QPresent[i]==false) {
					que.add(i);
					QPresent[i]=true;
				}
			}
		}
		breadthFirstTraversal(graph, que, visited, QPresent);
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
			
		System.out.println();
		
		for(int i=0;i<r_vertices;i++) {
			for(int j=0;j<r_vertices;j++) {
				System.out.print(am[i][j]+" ");
			}
			System.out.println();
		}
		
		Queue<Integer> que=new LinkedList<>();
		que.add(0);
		boolean visited[]=new boolean[r_vertices];
		boolean QPresent[]=new boolean[r_vertices];
		System.out.println();
		System.out.println("Breadth First Traversal ");
		System.out.println();
		QPresent[0]=true;
		breadthFirstTraversal(am, que, visited, QPresent);
		
	}
}
