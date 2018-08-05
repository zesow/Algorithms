import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{

	private static int m,n;
	private static int[][] a,d;
	private static int[] ai = {1,0,-1,0};
	private static int[] aj = {0,1,0,-1};
	private static Queue<Point> q = new LinkedList<>();

	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < n && j >= 0 && j < m)
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

	public static void bfs(){
		
		while(!q.isEmpty()){
			Point ptmp = q.poll();
			int i = ptmp.i;
			int j = ptmp.j;
			
			for(int k = 0 ; k < 4 ; ++k){
				int ni = i + ai[k];
				int nj = j + aj[k];

				if(isNotOut(ni,nj) == true && a[ni][nj] == 0){
					a[ni][nj] = a[i][j] + 1;
					q.add(new Point(ni,nj));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		m = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);

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

		bfs();

		int max = 0;
		int flag = 0;
		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < m ; ++j){
				if(a[i][j] == 0){
					flag = 1;
					max = -1;
					break;
				}

				if(a[i][j] > max)
					max = a[i][j];
			}

			if(flag == 1)
				break;
		}
		
		if(max != -1 )
			max -= 1;
		System.out.println(max);
	}
}
