package com.graphDemo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

	static class Edge {
		int src;
		int ngh;
		int wt;
		
		Edge(int src, int ngh, int wt){
			this.src=src;
			this.ngh=ngh;
			this.wt=wt;
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int v;
		String psf;
		int wsf;
		
		Pair(int v, String psf, int wsf){
			this.v=v;
			this.psf=psf;
			this.wsf=wsf;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}
	
	
	public static void main(String[] args) {
		Dijkstra d=new Dijkstra();
//			
//	        40           2
//	  0------------3-------------4
//	  |            |             | \
//	  |            |             |  \
//	10|            |10         3 |   \ 8
//	  |            |             |    \
//	  1------------2             5-----6
//	       10                       3
		
		int vces=7; // 0 1 2 3 4 5 6 7
		ArrayList<ArrayList<Edge>> graph=new ArrayList<ArrayList<Edge>>();
		
		for(int i=0; i<vces; i++) {
			graph.add(i, new ArrayList<Edge>());
		}
		
		graph.get(0).add(new Edge(0, 1, 10));
		graph.get(0).add(new Edge(0, 3, 40));
		
		graph.get(1).add(new Edge(1, 0, 10));
		graph.get(1).add(new Edge(1, 2, 10));
		
		graph.get(2).add(new Edge(2, 1, 10));
		graph.get(2).add(new Edge(2, 3, 10));
		
		graph.get(3).add(new Edge(3, 0, 40));
		graph.get(3).add(new Edge(3, 2, 10));
		graph.get(3).add(new Edge(3, 4, 2));
		
		graph.get(4).add(new Edge(4, 3, 2));
		graph.get(4).add(new Edge(4, 5, 3));
		graph.get(4).add(new Edge(4, 6, 8));
		
		graph.get(5).add(new Edge(5, 4, 3));
		graph.get(5).add(new Edge(5, 6, 3));
		
		graph.get(6).add(new Edge(6, 5, 3));
		graph.get(6).add(new Edge(6, 4, 8));
		
		System.out.println("Src via Cost");
		System.out.println("=================");
		
		System.out.println();
		PriorityQueue<Pair> pq=new PriorityQueue<>();
		boolean[] visited=new boolean[vces];
		pq.add(new Pair(graph.get(0).get(0).src, graph.get(0).get(0).src+"", 0));
		
		while(pq.size()>0) {
			//remove
			Pair p=pq.remove();
			
			if(visited[p.v]==true) {
				continue;
			}
			
			visited[p.v]=true;
			
			//print 
			System.out.println(p.v+" via "+p.psf+" @ "+p.wsf);
			
			//add neighbors
			ArrayList<Edge> n=graph.get(p.v);
			
			for(int i=0; i<n.size(); i++) {
				if(visited[n.get(i).ngh]==false) {
					pq.add(new Pair(n.get(i).ngh, p.psf+n.get(i).ngh, n.get(i).wt+p.wsf));
				}
			}
			
		}
	}

}
