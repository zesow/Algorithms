import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int[][] a, d;
	public static int t,n;

	private static int go(){
		d[0][0] = a[0][0];
		d[1][0] = a[1][0];

		d[0][1] = d[1][0] + a[0][1];
		d[1][1] = d[0][0] + a[1][1];

		for(int i = 2 ; i < n ; ++i){
			d[0][i] = Math.max(d[1][i-1],d[1][i-2]) + a[0][i];
			d[1][i] = Math.max(d[0][i-1],d[0][i-2]) + a[1][i];
		}
		return Math.max(d[0][n-1],d[1][n-1]);
		
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			n = Integer.parseInt(in.readLine());
			a = new int[2][n];
			d = new int[2][n];
			
			for(int i = 0 ; i < 2 ; ++i){
				String[] line = in.readLine().split(" ");
				for(int j = 0 ; j < n ;++j){
					a[i][j] = Integer.parseInt(line[j]);
				}
			}
			sb.append(go() + "\n");
			
		}

		out.write(sb.toString());

		in.close();
		out.close();
	}
}
