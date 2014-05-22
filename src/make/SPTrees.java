package make;

import java.util.TreeMap;

import data.Edge;
import data.Graph;
import data.Tree;

public class SPTrees {
	public static void makeAllSpanningTrees(Graph g){
		TreeMap<Integer, Tree> map = new TreeMap<>();
		for(int i=0;i<g.getV();i++){
			Tree t = new Tree(g.getVertex(i));
			map.put(i, t);
		}
		int k=0;
		int d=g.getVertex(0).getEdges().size();
		int m=0;
		while(true){			
			Edge cur=g.getEdge(k);
			if(k<g.getEdgelist().size()){
				int r1=map.get(cur.getV1().getNum()).getRoot();
				int r2=map.get(cur.getV2().getNum()).getRoot();
				if(r1!=r2){
					map.get(r1).mergeTree(map.get(r2), cur);
					map.remove(r2);
					m++;
					if(m==(g.getV()-1)){
						System.out.println(map.toString());
						if(k==d)
							break;
						Tree t2 = map.get(map.firstKey()).splitTree(cur);
						map.put(t2.getRoot(), t2);
						k++;
					}
					else{
						k++;
						continue;
					}
				}
				else{
					k++;
					continue;
				}				
			}
			else
				break;
		}
	}
}
