package data;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
	private Vertex[] graph;
	private ArrayList<Edge> edgeList;
	public Graph(int count) {
		super();
		this.graph = new Vertex[count];
		for(int i=0;i<count;i++){
			this.graph[i]=new Vertex(i);
		}
		edgeList = new ArrayList<>();
	}
	public int getV(){
		return graph.length;
	}
	public void addEdge(int from, int to){
		int min=Math.min(from, to);
		int max=Math.max(from, to);
		this.edgeList.add(new Edge(graph[min], graph[max]));
		this.graph[from].addEdge(to);
		this.graph[to].addEdge(from);
		Collections.sort(edgeList);
	}	
	public Vertex getVertex(Integer num){
		return graph[num];
	}
	public ArrayList<Edge> getEdgelist() {
		return edgeList;
	}
	public Edge getEdge(int num){
		return edgeList.get(num);
	}
}