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
		int tlast=-1;
		Edge last = null;
		while(true){			
			if(k<g.getEdgelist().size()){
				Edge cur=g.getEdge(k);
				int r1= map.get(cur.getV1().getR()).getRoot();;
				int r2= map.get(cur.getV2().getR()).getRoot();;
				if(r1!=r2){
					map.get(r1).mergeTree(map.get(r2), cur);
					last=cur;
					map.remove(r2);
					m++;
					if(m==(g.getV()-1)){
						System.out.println(map.toString());
						if(g.getEdgelist().indexOf(last)==d)
							break;
						Tree t2 = map.get(map.firstKey()).splitTree(last);
						m--;
						k=g.getEdgelist().indexOf(last)+1;
						tlast=map.firstKey();
						try {
							last=map.get(tlast).getEdgelist().last();
							map.put(t2.getRoot(), t2);
						} catch (Exception e) {
							
						}
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
				if(k==g.getEdgelist().size())
					break;
				else{					
					m--;
					if(!map.get(tlast).getEdgelist().isEmpty()){
						Tree t2 = map.get(tlast).splitTree(last);					
						k=map.get(tlast).getEdgelist().size()+1;					
						map.put(t2.getRoot(), t2);
					}
					continue;
				}
		}
	}
}
