import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Main{
	private static int n,k,shortest=100001,shortest_cnt=0;
	private static final int MAX = 100001;
	private static Queue<Integer> queue = new LinkedList<>();
	private static boolean[] check = new boolean[MAX];
	private static int[] cnt = new int[MAX];
	private static int[] dist = new int[MAX];
	
	public static void check(int before,int after){
		if(check[after] == false || dist[after] > dist[before] + 1){
			check[after] = true;
			queue.add(after);
			cnt[after] = cnt[before];
			dist[after] = dist[before] + 1;
		}
		else{
			if(dist[after] == dist[before] +1){
				cnt[after] += cnt[before];
			}
		}

	}
	public static void bfs(){
		queue.add(n);
		check[n] = true;
		cnt[n] = 1;
		dist[n] = 0;
		int now;
		while(!queue.isEmpty()){
			now = queue.poll();
			if(now == k){
				if(dist[now] < shortest){
					shortest = dist[now];
				}
				shortest_cnt = cnt[now];
			}

			if(now-1 >= 0 && now-1 < MAX){
				check(now,now-1);
			}
			if(now+1 >= 0 && now+1 < MAX){
				check(now,now+1);
			}
			if(now*2 >=0 && now*2 < MAX){
				check(now,now*2);
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);

		bfs();
		System.out.println(shortest);
		System.out.println(shortest_cnt);
	}
}
