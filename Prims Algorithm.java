package com.graphDemo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphDemo {

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
	
	public static class Pair implements Comparable<Pair>{
		int v;
		int av;
		int wt;
		
		Pair(int v, int av, int wt){
			this.v=v;
			this.av=av;
			this.wt=wt;
		}
		
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}
	
	public void display(ArrayList<ArrayList<Edge>> graph) {
		for(int i=0; i<graph.size(); i++) {
			System.out.println("Node: "+i);
	
			for(int j=0; j<graph.get(i).size(); j++) {
				System.out.println((graph.get(i).get(j).src)+"-"+(graph.get(i).get(j).ngh)+"-"+(graph.get(i).get(j).wt));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		GraphDemo g=new GraphDemo();
		
		int vces=7;
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
		
		//g.display(graph);
		
		//find spanning tree
		PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
		pq.add(new Pair(0, -1, 0));
		boolean[] visited=new boolean[vces];
		
		while(pq.size()>0) {
			Pair p=pq.remove();
			
			if(visited[p.v]==true) {
				continue;
			}
			visited[p.v]=true;
			
			//work
			if(p.av!=-1) {
				System.out.println(p.v+" - "+p.av+" @ "+p.wt);
			}
			
			//find neighbors
			ArrayList<Edge> n=graph.get(p.v);
			
			for(int i=0; i<n.size(); i++) {
				if(visited[n.get(i).ngh]==false) {
					pq.add(new Pair(n.get(i).ngh, n.get(i).src, n.get(i).wt));
				}
			}
		}
		
	}

}
