import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int n;
	public static long[] a,d;

	private static long go(){

		d[0] = a[0];
		long biggest = d[0];

		for(int i = 1 ; i < n ; ++i){
			d[i] = Math.max(a[i],d[i-1]+a[i]);
			if(d[i] > biggest)
				biggest = d[i];
		}

		return biggest;


	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(in.readLine());

		a = new long[n];
		d = new long[n];
		
		String[] line = in.readLine().split(" ");
		for(int i = 0 ; i < n ; ++i){
			a[i] = Integer.parseInt(line[i]);
		}
		sb.append(go());
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
