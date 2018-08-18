import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static int n,m;
	private static int[] a;
	private static boolean[] chk;

	public static void dfs(int cnt,int idx){

		if(cnt == m){
			for(int i = 0 ; i < m ; ++i){
				System.out.print(a[i]+1 + " ");
			}
			System.out.println();
			return;
		}

		for(int i = idx ; i < n ; ++i){
//			if(chk[i] == false){
//				chk[i] = true;
				a[cnt] = i;
				dfs(cnt+1,i);
//				chk[i] = false;
//			}
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		a = new int[n+1];
		chk = new boolean[n+1];

	
		dfs(0,0);
	}
}
