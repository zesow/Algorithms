import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int c,n;
	public static int[][] a,d;

	private static int go(int y,int x){
		
		if(y >= n || x >=n)
			return 1;
		if(y == n-1 && x == n-1)
			return 2;

		int jumpNum = a[y][x];
		if(d[y][x] != 0)
			return d[y][x];
		
		if(go(y+jumpNum,x) == 2 || go(y,x+jumpNum) ==2)
			d[y][x] = 2;
		else
			d[y][x] = 1;

		return d[y][x];
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		c = Integer.parseInt(in.readLine());

		while(c-- > 0){
			n = Integer.parseInt(in.readLine());
			a = new int[n][n]; d = new int[n][n];
			String[] line = null;
			for(int i = 0 ; i < n ; ++i){
				line = in.readLine().split(" ");
				for(int j = 0 ; j < n ; ++j){
					a[i][j] = Integer.parseInt(line[j]);
				}
			}

			int result = go(0,0);
			if(result == 2)
				sb.append("YES");
			else
				sb.append("NO");

			sb.append("\n");
		}

		out.write(sb.toString());

		in.close();
		out.close();

	}

}
