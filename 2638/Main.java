import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{

	private static class Point{
		int i,j;

		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	private static int m,n;
	private static int[][] a,d;
	private static int ai = {1,0,-1,0};
	private static int aj = {0,1,0,-1};
	private static Queue<Point> q = new LinkedList<>();
	private static int ans = 0;
	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < n && j >= 0 && j < m){
			return true;
		}
		return false;
	}
	public static void bfs(){
		
		while(!q.isEmpty()){
			Point tmp = q.poll();

			int i = tmp.i;
			int j = tmp.j;

			int cnt = 0;
			for(int k = 0 ; k < 4; ++k){
				int ni = i + ai[k];
				int nj = j + aj[k];

				if(a[ni][nj] == 0 )
					cnt++;
			}
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		a = new int[n][m];
		d = new int[n][m];
		
		for(int i = 0 ; i < n ; ++i){
			line = in.readLine().split(" ");
			for(int j = 0 ; j < m ; ++j){
				a[i][j] = Integer.parseInt(line[j]);
				if(a[i][j] == 1)
					q.add(new Point(i,j));
			}
		}

	}
}
