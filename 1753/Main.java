import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{

	private static int v,e,start;
	private static int[][] a;
	private static int[] result;

	public static void dfs(int now,int sum){

		if(result[now] > sum)
			result[now] = sum;

		for(int i = 1 ; i <= v ; ++i){
			if(a[now][i] != 0)
				dfs(i,sum+a[now][i]);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		v = Integer.parseInt(line[0]);
		e = Integer.parseInt(line[1]);
		a = new int[v+1][v+1];
		result = new int[v+1];
		Arrays.fill(result,Integer.MAX_VALUE);

		start = Integer.parseInt(in.readLine());

		for(int i = 0 ; i < e ; ++i){
			line = in.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);

			a[s][e] = w;
		}
		
		dfs(start,0);

		for(int i = 1 ; i <= v ; ++i){
			if(result[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(result[i]);
		}
	}
}
