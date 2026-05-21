import java.util.*;

class Edge{
	int dest;
	int weight;

	Edge(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
}

class Pair{
	int node;
	int distance;

	Pair(int node, int distance){
		this.distance = distance;
		this.node = node;
	}
}

public class Dijkstra{
	public static void dijkstra(List<List<Edge>> graph, int source){
		int n = graph.size();
		int[] distance = new int[n];
		int[] parent = new int[n];
		for(int i = 0; i < n; i++) parent[i] = i;
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.distance, b.distance));
		distance[source] = 0;
		pq.offer(new Pair(source, 0));
		while(!pq.isEmpty()){
			Pair current = pq.poll();

			int currentNode = current.node;
			int currentDistance = current.distance;

			if(currentDistance > distance[currentNode]){
				continue;
			}

			for(Edge edge : graph.get(currentNode)){
				int neighbor = edge.dest;
				int weight = edge.weight;

				if(distance[neighbor] > currentDistance + weight){
					distance[neighbor] = currentDistance + weight;
					parent[neighbor] = currentNode;
					pq.offer(new Pair(neighbor, distance[neighbor]));
				}

			}
		}
		for(int i = 0; i < n; i++){
		    System.out.println(
		        "Distance from source to node "
		        + i + " = " + distance[i]
		    );
		    System.out.println(parent[i] + "->" + i);
		}
	}

	public static void addEdge(List<List<Edge>> graph, int source, int dest, int weight){
		graph.get(source).add(new Edge(dest, weight));
		graph.get(dest).add(new Edge(source, weight));
	}

	public static void main(String[] args) {
		List<List<Edge>> graph = new ArrayList<>();
		int V = 5;

		for(int i = 0; i < V; i++){
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 1);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        dijkstra(graph, 0);
	}
}