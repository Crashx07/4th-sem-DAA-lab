import java.util.*;

class Edge{
	int source;
	int target;
	int weight;

	Edge(int source, int target, int weight){
		this.source = source;
		this.target = target;
		this.weight = weight;
	}
}

public class KruskalMST{
	public static void kruskal(List<List<Edge>> graph){
		int n = graph.size();
		int[] parent = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = i;
		}
		List<Edge> allEdges = new ArrayList<>();
		for(int i = 0; i < n; i++){
			for(Edge edge : graph.get(i)){
				if(edge.source < edge.target){
					allEdges.add(edge);
				}
			}
		}
		allEdges.sort((a,b) -> Integer.compare(a.weight, b.weight));

		List<Edge> mst = new ArrayList<>();
		int mstCost = 0;
		for(Edge edge : allEdges){
			if(find(parent, edge.source) == find(parent, edge.target)){
				continue;
			}
			union(parent, edge.source, edge.target);
			mst.add(edge);
			mstCost += edge.weight;

			if(mst.size() == n-1){
				break;
			}
		}

		for(Edge e : mst){
			System.out.println(e.source + "," + e.target + "->" + e.weight);
		}
		System.out.println("Total Weight =" + mstCost);
	}
	
	public static int find(int[] parent, int v){
		if(parent[v] == v){
			return v;
		}

		parent[v] = find(parent, parent[v])
		return parent[v];
	}

	public static void union(int[] parent, int u, int v){
		int rootU = find(parent, u);
		int rootV = find(parent, v);
		parent[rootU] = rootV;
	}

	public static void main(String[] args) {
		//main
	}
}