import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static int n,m;
	private static int[] a;
	private static boolean[] chk;
	private static StringBuffer sb = new StringBuffer();

	public static void dfs(int cnt){

		if(cnt == m){
			for(int i = 0 ; i < m ; ++i){
				sb.append(a[i]+1 + " ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0 ; i < n ; ++i){
			//if(chk[i] == false){
			//	chk[i] = true;
				a[cnt] = i;
				dfs(cnt+1);
			//	chk[i] = false;
			//}
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		a = new int[n+1];
		chk = new boolean[n+1];

	
		dfs(0);
		System.out.println(sb.toString());
	}
}
