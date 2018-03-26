import java.io.*;

class Main{

	public static int t,n,cnt;
	public static int[] a;
	public static boolean[] check;
	public static void dfs(int v){
		check[v] = true;

		if(check[a[v]] == false)
			dfs(a[v]);
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(in.readLine());
		while(t-- > 0){
			n = Integer.parseInt(in.readLine());
			a = new int[n+1];
			check = new boolean[n+1];
			cnt = 0;

			String[] line = in.readLine().split(" ");
			for(int i = 1 ; i <= n ; ++i){
				a[i] = Integer.parseInt(line[i-1]);
			}
			for(int i = 1; i <= n ; ++i){
				if(check[i] == false){
					dfs(i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
