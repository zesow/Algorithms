import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main_td{
	private static final long MOD = 1000000000;	
	public static long[][] d;
	public static int n;

	private static long go(int m,int l){
		if(m == 1){
			if(l == 0)
				return 0;
			return 1;
		}

		if(d[m][l] > 0)
			return d[m][l] % MOD;
		if(l == 0)
			d[m][l] = go(m-1,1) % MOD;
		else if(l == 9)
			d[m][l] = go(m-1,8) % MOD;
		else
			d[m][l] = go(m-1,l-1) % MOD + go(m-1,l+1) % MOD;

		return d[m][l] % MOD;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());
		d = new long[n+1][10];

		long sum = 0;
		for(int i =0 ; i < 10 ; ++i){
			sum += go(n,i) % MOD;
		}
		sb.append(sum % MOD);
		out.write(sb.toString());

		in.close();
		out.close();
	}
}

