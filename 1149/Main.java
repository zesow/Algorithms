import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static int n;
	private static int[][] a,d;
	public static void main(String[] args) throws Exception{


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		a = new int[n][3];
		d = new int[n][3];

		for(int i = 0 ; i < n; ++i){
			String[] line = in.readLine().split(" ");
			a[i][0] = Integer.parseInt(line[0]);
			a[i][1] = Integer.parseInt(line[1]);
			a[i][2] = Integer.parseInt(line[2]);


		}

		d[0][0] = a[0][0];
		d[0][1] = a[0][1];
		d[0][2] = a[0][2];

		for(int i = 1 ; i < n ; ++i){
			d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + a[i][0];
			d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + a[i][1];
			d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + a[i][2];
		}

		System.out.println(Math.min(d[n-1][0],Math.min(d[n-1][1],d[n-1][2])));
	}
}
