import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int c,n;
	public static int [][] a,d;

	public static int go(int y,int x){

		if(y==n-1)
			return a[y][x];

		if(d[y][x] > 0)
			return d[y][x];

		return d[y][x] = Math.max(go(y+1,x),go(y+1,x+1)) + a[y][x];
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		c = Integer.parseInt(in.readLine());

		while(c-- > 0){
			n = Integer.parseInt(in.readLine());
			a = new int[n][n]; d = new int[n][n];
			String[] line;
			for(int i = 0 ; i < n ; ++i){
				line = in.readLine().split(" ");
				for(int j = 0 ; j < line.length ; ++j){
					a[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			sb.append(go(0,0)+"\n");
		}

		out.write(sb.toString());
		in.close();
		out.close();
	}
}
