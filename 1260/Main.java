import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Main{

	public static int n,m,v;
	public static ArrayList<Integer>[] a;
	public static boolean[] check;
	
	public static void bfs(int x){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		check[x] = true;

		while(!q.isEmpty()){
			int head = q.remove();
			System.out.print(head + " " );
			for(int i = 0 ; i < a[head].size(); ++i){
				int y = a[head].get(i);
				if(check[y] == false){
					q.add(y);
					check[y] = true;
				}
			}
		}
	}
	public static void dfs(int x){
		check[x] = true;
		System.out.print(x + " ");
		for(int i = 0 ; i < a[x].size(); ++i){
			int y = a[x].get(i);
			if(check[y] == false)
				dfs(y);
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		v = Integer.parseInt(line[2]);

		a = new ArrayList[n+1];
		for(int i = 1 ; i <= n ; ++i)
			a[i] = new ArrayList<Integer>();

		check = new boolean[n+1];

		int x,y;
		for(int i = 0 ; i < m ; ++i){	
			line = in.readLine().split(" ");
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
			a[x].add(y); a[y].add(x);
		}
		
		for(int i = 1 ; i <= n ; ++i)
			Collections.sort(a[i]);

		dfs(v);
		System.out.println();
		check = new boolean[n+1];
		bfs(v);
	}
}

