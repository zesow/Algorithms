import java.io.*;
import java.util.ArrayList;

class Main{

	public static int n,m,cnt=0;
	public static ArrayList<Integer>[] a;
	public static boolean[] check;

	public static void dfs(int x){
		check[x] = true;
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
		a = new ArrayList[n+1];
		check = new boolean[n+1];
		for(int i = 1 ; i <= n ; ++i){
			a[i] = new ArrayList<Integer>();
		}

		for(int i = 0 ; i < m ; ++i){
			line = in.readLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);

			a[x].add(y);a[y].add(x);
		}

		for(int i = 1 ; i <= n; ++i){
			if(check[i] == false){
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);
	}
}
