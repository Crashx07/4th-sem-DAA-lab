import java.util.*;

class Reacheable{
	public static boolean reachable(List<List<Integer>> graph, int current, int target, boolean[] visited){
		if(current == target){
			return true;
		}

		visited[current] = true;
		for(int neighbor : graph.get(current)){
			if(!visited[neighbor]){
				if(reachable(graph, neighbor, target, visited))
					return true;
			}
		}
		return false;
	}
}