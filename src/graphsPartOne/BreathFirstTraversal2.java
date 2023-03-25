package graphsPartOne;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreathFirstTraversal2 {
	
	public static void breadthFirstTraversal(int graph[][]) {
		int n = graph.length;
        boolean[] visited = new boolean[n];
		for(int i=0;i<graph.length;i++){
			if(!visited[i]){
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				visited[i] = true;
				while (!q.isEmpty()) {
					int u = q.poll();
					System.out.print(u + " ");
					for (int v = 0; v < n; v++) {
						if (graph[u][v] == 1 && !visited[v]) {
							visited[v] = true;
							q.offer(v);
						}
					}
				}
			}
		}
         
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
        
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		
		/*
		 Input - 
		 6 5 
		 0 1 
		 0 2 
		 1 3 
		 3 2 
		 4 5 
		 Output -
		 0 1 2 3 4 5
		 */
		
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
			return;
		}

		int am[][]=new int[r_vertices][r_vertices];
		
		for(int i=0;i<c_edges;i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			am[v1][v2]=1;
			am[v2][v1]=1;
		}
			
		// System.out.println();
		
		// for(int i=0;i<r_vertices;i++) {
		// 	for(int j=0;j<r_vertices;j++) {
		// 		System.out.print(am[i][j]+" ");
		// 	}
		// 	System.out.println();
		// }
		
		Queue<Integer> que=new LinkedList<>();
		que.add(0);
		boolean visited[]=new boolean[r_vertices];

		//boolean QPresent[]=new boolean[r_vertices];
		// System.out.println();
		// System.out.println("Breadth First Traversal ");
		// System.out.println();
		//QPresent[0]=true;
		breadthFirstTraversal(am);
		
	}
	
}
