import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Solution{

	private static int[][] a = null;
	private static int[][] d = null;
	
	private static class Point{
		int i,j;

		Point(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	private static Point start = null;
	private static int[] ai = {1,0,-1,0};
	private static int[] aj = {0,1,0,-1};
	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < 100 && j >= 0 && j < 100)
			return true;
		return false;
	}

	public static int bfs(Point p){
		Queue<Point> q = new LinkedList<>();

		d[p.i][p.j] = 1;		
		q.add(p);

		while(!q.isEmpty()){
			Point ptmp = q.poll();
			int i = ptmp.i;
			int j = ptmp.j;
			if(a[i][j] == 3){
				return 1;
			}
			for(int k = 0 ; k < 4; ++k){
				int ni = i + ai[k];
				int nj = j + aj[k];

				if(isNotOut(ni,nj) == true && (a[ni][nj] == 0 || a[ni][nj] == 3) && d[ni][nj] == 0 ){
					q.add(new Point(ni,nj));
					d[ni][nj] = 1;
				}
			}
		}

		return 0;
	}
	
	public static int dfs(Point p){
		int i = p.i;
		int j = p.j;

		if(a[i][j] == 3)
			return 1;


		for(int k = 0 ; k < 4; ++k){
			int ni = i + ai[k];
			int nj = j + aj[k];

			if(isNotOut(ni,nj) == true && (a[ni][nj] == 0 || a[ni][nj] == 3) && d[ni][nj] == 0 ){
				d[ni][nj] = 1;
				int result = dfs(new Point(ni,nj));
				if(result == 1)
					return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args){
		

		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			for(int i = 1; i <= 10 ; ++i){

				line = in.readLine();
				a = new int[100][100];
				d = new int[100][100];
				for(int j = 0 ; j < 100 ; ++j){
					line = in.readLine();
					for(int k = 0 ; k < 100 ; ++k){
						a[j][k] = line.charAt(k) - 48;
						if(a[j][k] == 2){
							start = new Point(j,k);
						}
					}
				}
				
				//int result = bfs(start);
				int result = dfs(start);
				System.out.println("#"+i+" "+result);
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
