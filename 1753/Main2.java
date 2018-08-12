import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
class Main2{

	private static int v,e,start;
	private static int[] result;
	private static boolean[] visited;
	private static class EW{
		int e,w;

		EW(int e,int w){
			this.e=e;
			this.w=w;
		}
	}
	public static ArrayList<EW>[] a = null;
	public static void bfs(){

		//PriorityQueue<Integer> q = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		result[start] = 0;
		while(!q.isEmpty()){
			int now = q.poll();
			System.out.println(now);
			visited[now] = true;


			for(EW ew : a[now]){
				int next = ew.e;
				int w = ew.w;

				if(result[next] > result[now] + w){
					result[next] = result[now] + w;
					q.add(next);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		v = Integer.parseInt(line[0]);
		e = Integer.parseInt(line[1]);
		a = new ArrayList[v+1];
		for(int i = 0 ; i <= v ; ++i){
			a[i] = new ArrayList<EW>();
		}

		result = new int[v+1];
		visited = new boolean[v+1];
		Arrays.fill(result,Integer.MAX_VALUE);

		start = Integer.parseInt(in.readLine());

		for(int i = 0 ; i < e ; ++i){
			line = in.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);

			a[s].add(new EW(e,w));
		}
		
		bfs();

		for(int i = 1 ; i <= v ; ++i){
			if(visited[i] == false)
				System.out.println("INF");
			else
				System.out.println(result[i]);
		}
	}
}
