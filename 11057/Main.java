import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	private static final int MOD = 10007;
	public static int n;
	public static int[][] d;

	private static int go(int n,int l){
		if(n == 1)
			return 1;

		if(d[n][l] > 0)
			return d[n][l];

		for(int i = 0 ; i <= l; ++i){
			d[n][l] += go(n-1,i) % MOD;
		}

		return d[n][l] % MOD;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());
		d = new int[n+1][10];

		int sum = 0;
		for(int i = 0 ; i<10;++i){
			sum += go(n,i) % MOD;
		}
		sb.append(sum % 10007);
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
