import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static long[] a,d;
	public static int n;
	
	private static long go(int n){

		if(n == 0)
			return 0;
		if(n == 1)
			return a[1];

		if(n == 2)
			return a[1] + a[2];

		if(d[n] > 0)
			return d[n];

		long t1 = go(n-1);
		long t2 = a[n] + go(n-2);
		long t3 = a[n] + a[n-1] +go(n-3);

		d[n] = t1 > t2? t1 : t2 > t3? t2 : t3;
		
		return d[n];

	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());

		a = new long[n+1];
		d = new long[n+1];

		for(int i = 1 ; i <= n ; ++i){
			a[i] = Long.parseLong(in.readLine());
		}

		sb.append(go(n));

		out.write(sb.toString());

		in.close();
		out.close();
	}
}




		
