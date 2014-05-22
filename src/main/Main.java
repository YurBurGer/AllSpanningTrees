package main;

import java.io.FileNotFoundException;

import make.SPTrees;
import reading.ReadGraph;
import data.Graph;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("text");
		Graph g = ReadGraph.ReadGraphFromEdgeList("Test");
		SPTrees.makeAllSpanningTrees(g);
	}

}
