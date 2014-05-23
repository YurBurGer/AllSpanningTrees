package make;

import java.util.Random;
import java.util.TreeSet;

import data.Edge;
import data.Graph;

public class Tests {
	public static Graph makeRandomGraph(int n, int m){
		Random r = new Random();
		Graph g = new Graph(n);
		TreeSet<Edge> set = new TreeSet<>();
		int i=0;
		while(i<m){
			int v1=r.nextInt(n);
			int v2=r.nextInt(n);
			if(set.add(new Edge(g.getVertex(v1), g.getVertex(v2))))
				i++;
		}
		g.getEdgelist().addAll(set);
		return g;
	}
}
