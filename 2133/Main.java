import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int n;
	public static int[] d;

	private static int go(){
		d[2] = 3;


		return d[n];
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		d = new int[n+1];

		sb.append(go());
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
