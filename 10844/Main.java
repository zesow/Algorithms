import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
	public static int[][] d;
	private static long go(int n){
		d = new int[n+1][10];
		
		for(int i = 1 ; i <=9 ; ++i){
			d[1][i] = 1;
		}

		for(int i = 2 ; i <= n; ++i){
			for(int j = 0; j < 10 ; ++j){
				if(j == 0)
					d[i][j] = d[i-1][j+1] % 1000000000;
				else if(j == 9)
					d[i][j] = d[i-1][j-1] % 1000000000;
				else
					d[i][j] = (d[i-1][j-1] % 1000000000) + (d[i-1][j+1] % 1000000000);
			}
		}

		long sum = 0;
		for(int i = 0 ; i < 10; ++i){
			sum += d[n][i] % 1000000000;
		}

		return sum % 1000000000;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());
		sb.append(go(n));
		out.write(sb.toString());

		in.close();
		out.close();
	}
}

