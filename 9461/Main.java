import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int t,n;
	public static long[] d;

	private static void go(){
		d[0] = d[1] = d[2] = 1;
		d[3] = d[4] = 2;

		for(int i = 5; i < n ; ++i){
			d[i] = d[i-1] + d[i-5];
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(in.readLine());
		while(t-- > 0){
			n = Integer.parseInt(in.readLine());
			d = new long[101];

			go();
			sb.append(d[n-1]+ "\n");
		}
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
