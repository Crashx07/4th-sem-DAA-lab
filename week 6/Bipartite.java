import java.util.*;

class Bipartite{
	public static boolean bipartite(List<List<Integer>> graph){
		int n = graph.size();
		int[] color = new int[n];
		Arrays.fill(color, -1);
		for(int start = 0; start < n; start++){
			if(color[start] == -1){
				Queue<Integer> q = new LinkedList<>();
				color[start] = 0;
				q.offer(start);
				while(!q.isEmpty()){
					int curr = q.poll;
					for(int neighbor : graph.get(curr)){
						if(color[neighbor] == -1){
							color[neighbor] = 1 - color[curr];
							q.offer(neighbor);
						} else if(color[neighbor] == color[curr]){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		//Main
	}
}