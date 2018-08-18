import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2{

	private static int n;
	private static int[] a;
	private static int[][] d;
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		a = new int[n+1];
		d = new int[n+1][n+1];
		for(int i = 1 ; i <= n; ++i){
			a[i] = Integer.parseInt(in.readLine());
		}
		d[1][0] = d[1][1] = a[1];

		for(int i = 2; i <= n ; ++i){
			d[i][0] = d[i-1][1] + a[i];
			d[i][1] = (d[i-2][0] > d[i-2][1]? d[i-2][0] : d[i-2][1]) + a[i];
		}

		System.out.println(d[n][0] > d[n][1] ? d[n][0] : d[n][1]);

	}
}
