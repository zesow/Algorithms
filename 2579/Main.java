import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int n;
	public static int[] a;
	public static int[][] d;
	
	private static int go(){
		 
		d[0][0] = 0;
		d[0][1] = a[0];
		d[1][0] = a[0];
		d[1][1] = a[0] + a[1];

		for(int i = 2 ; i < n ; ++i){
			d[i][0] = d[i-1][1];
			d[i][1] = Math.max(a[i]+a[i-1]+d[i-2][0],a[i]+d[i-1][0]);
		}
		
		return d[n-1][1];
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		d = new int[n][2];

		for(int i = 0 ; i < n ; ++i){
			a[i] = Integer.parseInt(in.readLine());
		}

		sb.append(go());
		out.write(sb.toString());
		
		in.close();
		out.close();

	}
}
