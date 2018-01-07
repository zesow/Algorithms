import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class Main{
	public static int[] d;

	private static int go(int n){

		if(n <= 1)
			return 1;

		if(d[n] > 0)
			return d[n];

		d[n] = go(n-2) + go(n-1);
		d[n] %= 10007;
		return d[n];

	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();		
		int n;
		n = Integer.parseInt(in.readLine());
		d = new int[n+1];

		sb.append(go(n));
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
