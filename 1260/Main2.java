import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

class Main2{
	public static int n,m,v;
	public static int[][] a;
	public static boolean[] check;
	
	public static void dfs(int v){
		check[v] = true;
		System.out.print(v + " ");

		for(int i = 1 ; i <= n; ++i){
			if(a[v][i] == 1 && check[i] == false)
				dfs(i);
		}
	}
	public static void bfs(int v){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		check[v] = true;

		while(!q.isEmpty()){
			int y = q.remove();
			System.out.print(y + " ");
			for(int i = 1 ; i <= n ; ++i){
				if(a[y][i] == 1 && check[i] == false){
					q.add(i);
					check[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		v = Integer.parseInt(line[2]);
		
		a = new int[n+1][n+1];

		int x,y;
		for(int i = 0 ; i < m ; ++i){
			line = in.readLine().split(" ");
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
			a[x][y] = 1; a[y][x] = 1;
		}
		
		check = new boolean[n+1];
		dfs(v);
		System.out.println();
		check = new boolean[n+1];
		bfs(v);

	}
}
