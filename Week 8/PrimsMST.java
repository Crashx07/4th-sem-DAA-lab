import java.util.*;
class Edge{
	int target;
	int weight;

	Edge(int target, int weight){
		this.target = target;
		this.weight = weight;
	}
}

class PQEntry{
	int source;
	int target;
	int weight;

	PQEntry(int source, int target, int weight){
		this.weight = weight;
		this.source = source;
		this.target = target;
	}

}
public class PrimsMST{
	public static void prim_Lazy(List<List<Edge>> graph, int start){
		int n = graph.size();
		boolean[] visited = new boolean[n];

		PriorityQueue<PQEntry> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
		pq.offer(new PQEntry(-1, start, 0));
		int mstCost = 0;
		while(!pq.isEmpty()){
			PQEntry curr = pq.poll();

			if(visited[curr.target]){
				continue;
			}
			visited[curr.target] = true;
			mstCost += curr.weight;
			if(curr.source != -1){
			    System.out.println(
			        curr.source + " -> " +
			        curr.target + " : " +
			        curr.weight
			    );
			}
			for(Edge neighbor : graph.get(curr.target)){
				if(!visited[neighbor.target]){
					pq.offer(new PQEntry(curr.target, neighbor.target, neighbor.weight));
				}
			}
		}
		System.out.println("MST Cost: " + mstCost);
	}


	class PQNode{
		int vertex;
		int edgeCost;

		PQNode(int vertex, int edgeCost){
			this.vertex = vertex;
			this.edgeCost = edgeCost;
		}
	}

	public static void prim(List<List<Edge>> graph, int start){
		int n = graph.size();
		int[] edgeCost = new int[n];
		Arrays.fill(edgeCost, Integer.MAX_VALUE);
		int[] parent = new int[n];
		boolean[] visited = new boolean[n];
		int mstCost = 0;
		PriorityQueue<PQNode> pq= new PriorityQueue<>((a,b) -> Integer.compare(a.edgeCost, b.edgeCost));

		edgeCost[start] = 0;
		parent[start] = -1;
		pq.offer(new PQNode(start, 0));
		while(!pq.isEmpty()){
			PQNode curr = pq.poll();

			if(visited[curr.vertex]){
				continue;
			}
			visited[curr.vertex] = true;
			mstCost += curr.weight;
			for(Edge neighbor : graph.get(curr.vertex)){
				if(!visited[neighbor.target]){
					if(edgeCost[neighbor.target] > neighbor.weight){
						edgeCost[neighbor.target] = neighbor.weight;
						parent[neighbor.target] = curr.vertex;
						pq.offer(new PQNode(neighbor, edgeCost[neighbor.target]));
					}
				}
			}
		}
		System.out.println(mstCost);
	}

	public static void addEdge(List<List<Edge>> graph, int source, int target, int weight){
		graph.get(source).add(new Edge(target, weight));
		graph.get(source).add(new Edge(source, weight));
	}
	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		int V = 5;

		for(int i = 0; i < V; i++){
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        prim_Lazy(graph, 0);

	}
}