package graphsPartOne;

class EdgeNode{
	int edgeNode;
	EdgeNode next;
	
	public EdgeNode(int edgeNode) {
		this.edgeNode=edgeNode;
		this.next=null;
	}
}

class EdgeNodeList{
	EdgeNode head;
	public EdgeNodeList(EdgeNode head) {
		this.head=head;
	}
}

class Graph{
	int vertex;
	EdgeNodeList list;
	
	public Graph(int vertex) {
		this.vertex=vertex;
		this.list=null;
	}
}

public class GraphImplementationUsingList {
	
	public static void main(String args[]) {
		Graph v1=new Graph(0);
		EdgeNode e1=new EdgeNode(1);
		EdgeNode e2=new EdgeNode(2);
		e1.next=e2;
		v1.list=new EdgeNodeList(e1);
		
		printVertex(v1);
		
	}
	
	public static void printVertex(Graph g) {
		
		System.out.println("Vertex is - "+g.vertex );
		while(g.list.head!=null) {
			System.out.println("Edge Node is - "+g.list.head.edgeNode );
			g.list.head=g.list.head.next;
		}
	}
}
