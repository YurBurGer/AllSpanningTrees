package data;

import java.util.TreeMap;
import java.util.TreeSet;

public class Tree {
	private TreeMap<Integer, Vertex> graph;
	private TreeSet<Edge> edgeList;
	private int root;
	public Tree(Vertex v) {
		super();
		graph = new TreeMap<>();
		graph.put(v.getNum(), v);
		edgeList = new TreeSet<>();
		this.changeRoot(v.getNum());
	}
	public Vertex getVertex(Integer num){
		return graph.get(num);
	}
	public TreeSet<Edge> getEdgelist() {
		return edgeList;
	}
	public int getRoot() {
		return root;
	}	
	public TreeMap<Integer, Vertex> getGraph() {
		return graph;
	}
	public void changeRoot(int newRoot){
		int xj=newRoot;
		int z=graph.get(xj).getP();
		int xi=z;
		while(xi!=-1){
			xi=z;
			z=graph.get(xi).getP();
			graph.get(xi).setP(xj);
			xj=xi;
		}
		root=newRoot;
		graph.get(root).setP(-1);
		for(Vertex v:graph.values()){
			v.setR(root);
		}
	}
	public void mergeTree(Tree t2, Edge e){
		edgeList.add(e);
		edgeList.addAll(t2.getEdgelist());
		t2.changeRoot(e.getV2().getNum());
		if(t2.graph.keySet()!=null)
			for(int i:t2.graph.keySet()){
				graph.get(i).setR(root);			
			}
		this.graph.putAll(t2.getGraph());
	}
	public Tree splitTree(Edge e){
		Tree t2 = new Tree(e.getV2());
		TreeSet<Integer> ps=new TreeSet<>();
		ps.add(graph.get(e.getV2()).getP());
		int oldroot=root;
		this.changeRoot(e.getV1().getNum());
		graph.remove(e.getV1().getNum());
		boolean f=true;
		while(f){
			f=false;
			for(int i:graph.keySet()){
				if(ps.contains(graph.get(i).getP())){
					f=true;
					ps.add(graph.get(i).getP());
					t2.graph.put(i, graph.get(i));
					for(Edge e1:edgeList){
						if((e1.getV1().getNum()==i)||(e1.getV2().getNum()==i)){
							t2.edgeList.add(e1);
							edgeList.remove(e1);
						}
					}	
					graph.remove(i);
				}
			}			
		}
		this.changeRoot(oldroot);
		return t2;
	}
	@Override
	public String toString() {
		return "Tree [graph=" + graph + ", edgeList=" + edgeList + "]";
	}	
}