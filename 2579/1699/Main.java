import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int n;
	public static int[] d;
	private static int go(){

		for(int i = 1 ; i <= n ; ++i){
			d[i] = i;
			for(int j = 2; j*j <= i ; ++j){
				if(d[i] > d[i-j*j] + 1)
					d[i] = d[i-j*j] + 1;
			}
		}

		return d[n];
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(in.readLine());

		d = new int[n+1];
		
		StringBuilder sb = new StringBuilder();
		sb.append(go());
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
