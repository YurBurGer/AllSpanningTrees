package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import make.SPTrees;
import make.Tests;
import data.Graph;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("text");
		PrintWriter pw = new PrintWriter("res.txt");
		for(int n=3;n<10;n++){		
			for(int m=n/2;m<n*(n-1);m*=2){
				for(int i=0;i<10;i++){	
					Graph test=Tests.makeRandomGraph(n, m);
					pw.print("{"+n+","+m);
					long start=System.currentTimeMillis();
					SPTrees.makeAllSpanningTrees(test);
					long stop=System.currentTimeMillis();
					pw.println(","+(stop-start)+"},");
					System.out.println(m+" "+n+" "+i);
				}
			}
		}		
		pw.close();
	}

}
