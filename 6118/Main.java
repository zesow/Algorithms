import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Main{

	private static int n,m;
	private static ArrayList<Integer>[] a = null;
	private static int[] dist = null;
	
	public static void bfs(){

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		dist[1] = 0;
		while(!q.isEmpty()){
			int now = q.poll();

			for(int next : a[now]){
				if(dist[next] > dist[now] + 1){
					
					dist[next] = dist[now] + 1;
					q.add(next);

				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		a = new ArrayList[n+1];
		dist = new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);

		for(int i = 0 ; i <= n ; ++i){
			a[i] = new ArrayList<Integer>();
		}

		for(int i = 0 ; i < m ; ++i){
			line = in.readLine().split(" ");
			int a_i = Integer.parseInt(line[0]);
			int b_i = Integer.parseInt(line[1]);

			a[a_i].add(b_i);
			a[b_i].add(a_i);
		}

		bfs();

		int max = dist[1];
		int num=0,cnt=1;
		for(int i = 2 ; i < dist.length; ++i){
			if(dist[i] > max){
				num = i;
				max = dist[i];
				cnt = 1;
			}
			else if( dist[i] == max)
				cnt += 1;

		}

		System.out.println(num + " " + max + " " + cnt);

	}
}
