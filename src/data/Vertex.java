package data;

import java.util.ArrayList;


public class Vertex implements Comparable<Vertex>{
	private int num;
	private int r,p;
	private ArrayList<Integer> edges;
	public Vertex(int num) {
		super();
		this.num = num;
		this.r=num;
		this.p=-1;
		this.edges=new ArrayList<>();
	}
	public int getNum() {
		return num;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	@Override
	public int compareTo(Vertex arg0) {
		return num-arg0.num;
	}
	public boolean addEdge(int e){
		return edges.add(e);		
	}
	@Override
	public int hashCode() {
		final int prime = 20482048;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + num;
		result = prime * result + p;
		result = prime * result + r;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (num != other.num)
			return false;
		return true;
	}	
	public ArrayList<Integer> getEdges(){
		return edges;
	}
	@Override
	public String toString() {
		return "Vertex [num=" + num + ", r=" + r + ", p=" + p + "]";
	}
}