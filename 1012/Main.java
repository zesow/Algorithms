import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{

	private static int t,m,n,k,wNum = 1;
	private static int[][] a,d;
	private static class Point{
		int i,j;

		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	private static int[] ai = {1,0,-1,0};
	private static int[] aj = {0,1,0,-1};
	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < n && j >= 0 && j < m)
			return true;
		return false;
	}
	public static void bfs(Point pt){
		Queue<Point> q = new LinkedList<>();
		q.add(pt);
		
		while(!q.isEmpty()){
			Point ptmp = q.poll();
			int i = ptmp.i;
			int j = ptmp.j;

			for(int z = 0 ; z < 4 ; ++z){
				int ni = i + ai[z];
				int nj = j + aj[z];

				if(isNotOut(ni,nj) == true && a[ni][nj] == 1 && d[ni][nj] == 0){
					d[ni][nj] = wNum;
					q.add(new Point(ni,nj));
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		t = Integer.parseInt(line[0]);

		while(t-- > 0){
			wNum = 1;
			line = in.readLine().split(" ");
			m = Integer.parseInt(line[0]);
			n = Integer.parseInt(line[1]);
			k = Integer.parseInt(line[2]);

			a = new int[n][m];
			d = new int[n][m];

			for(int z = 0 ; z < k ; ++z){
				line = in.readLine().split(" ");
				int j = Integer.parseInt(line[0]);
				int i = Integer.parseInt(line[1]);
				a[i][j] = 1;
			}

			for(int i = 0 ; i < n ; ++i){
				for(int j = 0 ; j < m ; ++j){
					if(a[i][j] == 1 && d[i][j] == 0){
						d[i][j] = wNum;
						bfs(new Point(i,j));
						wNum += 1;
					}
				}
			}

			System.out.println(wNum - 1);
		}
	}
}
