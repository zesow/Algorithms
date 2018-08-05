import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{

	private static int m,n;
	private static char[][] a;
	private static int[][] d;
	private static int[] ai = {1,0,-1,0};
	private static int[] aj = {0,1,0,-1};
	private static int fMax = -1;

	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < m && j >= 0 && j < n)
			return true;
		return false;
	}
	private static class Point{
		int i,j;

		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void bfs(Point pt){

		Queue<Point> q = new LinkedList<>();
		int max = -1;
		q.add(pt);

		while(!q.isEmpty()){
			Point ptmp = q.poll();
			int i = ptmp.i;
			int j = ptmp.j;

			for(int k = 0 ; k < 4 ; ++k){
				int ni = i + ai[k];
				int nj = j + aj[k];

				if(isNotOut(ni,nj) == true && a[ni][nj] == 'L' && d[ni][nj] == 0){
					d[ni][nj] = d[i][j] + 1;
					q.add(new Point(ni,nj));

					if(d[ni][nj] > max)
						max = d[ni][nj];
				}
			}
		}
		
		if(max > fMax)
			fMax = max;
	}
	public static void main(String[] args) throws Exception{

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] lines = in.readLine().split(" ");
		m = Integer.parseInt(lines[0]);
		n = Integer.parseInt(lines[1]);

		a = new char[m][n];
		d = new int[m][n];

		for(int i = 0 ; i < m ; ++i){
			String line = in.readLine();
			for(int j = 0 ; j < line.length(); ++j){
				a[i][j] = line.charAt(j);
			}
		}

		for(int i = 0; i < m ; ++i){
			for(int j = 0 ; j < n ; ++j){
				if(a[i][j] == 'L'){
					d = new int[m][n];
					bfs(new Point(i,j));
					d[i][j] = 1;
				}
			}
		}
		
		System.out.println(fMax);
	}
}
