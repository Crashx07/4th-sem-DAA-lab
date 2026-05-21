import java.util.*;

public class MotherVertex{
	public static void DFS(List<List<Integer>> graph, int vertex, boolean[] visited){
		visited[vertex] = true;
		for(Integer neighbor : graph.get(V)){
			if(!visited[neighbor]){
				DFS(graph, neighbor, visited);
			}
		}
	}

	public static int motherVertex(List<List<Integer>> graph, int V){
		if(V == 0) return-1;
		boolean[] visited = new boolean[V];
		int candidate = -1;
		for(int vertex = 0; vertex < V; vertex++){
			if(!visited[vertex]){
				DFS(graph, vertex, visited);
				candidate = vertex;
			}
		}

		Arrays.fill(visited, false);
		DFS(graph, candidate, visited);

		for(int i = 0; i < V; i++){
			if(!visited[i]) return -1;
		}

		return candidate;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		int V = sc.nextInt();
		List<List<Integer>> graph = new ArrayList<>(V);
		for(int i = 0; i < V; i++){
			graph.add(new ArrayList<>());
		}

        System.out.println("Enter the number of edges:");
        int E = sc.nextInt();

        System.out.println("Enter edges (source and destination):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v); 
        }
        int candidate = motherVertex(Graph, V);
        if(candidate == -1){
        	System.out.println("No mother vertex found!");
        }else{
        	System.out.println("Mother vertex = "+ candidate);
        }
	}
}