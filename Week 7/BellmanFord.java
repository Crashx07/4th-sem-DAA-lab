import java.util.*;

class Edge{
	int dest;
	int weight;

	Edge(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
}

public class BellmanFord{
	public static void bellmanFord(List<List<Edge>> graph, int source){
		int V = graph.size();
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;
		for(int i = 0; i < V-1; i++){
			for(int curr = 0; curr < V; curr++){
				for(Edge edge : graph.get(curr)){
					int neighbor = edge.dest;
					if(distance[curr] != Integer.MAX_VALUE 
						&& 
						distance[neighbor] > distance[curr] + edge.weight){
						distance[neighbor] = distance[curr] + edge.weight;
					}
				}
			}
		}

		for(int curr = 0; curr < V; curr++){
			for(Edge edge : graph.get(curr)){
				int neighbor = edge.dest;

				if(distance[curr] != Integer.MAX_VALUE 
					&& 
					distance[neighbor] > distance[curr] + edge.weight){
					System.out.println("Negative cycle detected");
					return;
				}
			}
		}
		for(int i = 0; i < V; i++){
		    if(distance[i] == Integer.MAX_VALUE){
		        System.out.println(i + " is unreachable");
		    }
		    else{
		        System.out.println("Distance to " + i + " = " + distance[i]);
		    }
		}
	}
	public static void main(String[] args) {
		//
	}
}