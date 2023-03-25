package graphsPartOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {
	
	public static ArrayList<Integer> getPathBFS(int graph[][], boolean visited[], int s, int e){
		
		Queue<Integer> q=new LinkedList<Integer>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		q.add(s);
		map.put(s, -1);
		visited[s]=true;
		int currentVertex;
		
		while(q.peek()!=null) {
			currentVertex=q.poll();
			for(int i=0;i<graph.length;i++) {
				if(graph[currentVertex][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i]=true;
					map.put(i, currentVertex);
					
					if(i==e) {
						ArrayList<Integer> arr=new ArrayList<Integer>();
						arr.add(e);
						int temp=e;
						while(temp!=-1) {
							temp=map.get(temp);
							if(temp==-1) {
								break;
							}
							arr.add(temp);
						}
						return arr;
					}
				}
				
			}
		}
		
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
		
		boolean visited[]=new boolean[r_vertices];

		ArrayList<Integer> output=getPathBFS(am, visited, start, end);
		
		if(output!=null) {
			for(int i=0;i<output.size();i++) {
				System.out.print(output.get(i)+" ");
			}
				
		}
		
	}
	
}
