import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
 
	private static long[][] d = new long[91][91];

	private static int n;
	public static void main(String[] args) throws Exception{


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());

		d[1][0] = 0;
		d[1][1] = 1;

		for(int i = 2 ; i <= n ; ++i){
			d[i][0] = d[i-1][0] + d[i-1][1];
			d[i][1] = d[i-1][0];
		}

		System.out.println(d[n][0] + d[n][1]);
	}
}
