import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
	int i,j;
	Pair(int i,int j){
		this.i = i;
		this.j = j;
	}
}
class Main{
	public static int n,m,min = 100000;
	public static int[][] a,d;
	public static int[] ai = {1,0,-1,0};
	public static int[] aj = {0,1,0,-1};
	
	public static boolean isNotOut(int ni,int nj){
		if(ni >= 0 && ni < n && nj >=0 && nj < m)
			return true;
		return false;
	}
	
	public static void dfs(int i,int j){

		if(i == n-1 && j == m-1){
			if(min > d[i][j])
				min = d[i][j];
			return;
		}

		for(int k = 0 ; k < 4; ++k){
			int ni = i + ai[k];
			int nj = j + aj[k];

			if(isNotOut(ni,nj) == true && a[ni][nj] == 1 && d[ni][nj] == 0){
				d[ni][nj] = d[i][j] + 1;
				dfs(ni,nj);
				d[ni][nj] = 0;
			}
		}

		return;
		
	}

	public static void bfs(int i,int j){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		d[0][0] = 1;

		while(!q.isEmpty()){
			Pair tmp = q.remove();
			int y = tmp.i;
			int x = tmp.j;
			if(y == n-1 && x == m-1){
				if(min > d[y][x])
					min = d[y][x];
				return;
			}
			for(int k = 0 ; k < 4 ; ++k){
				int ny = y + ai[k];
				int nx = x + aj[k];
				if(isNotOut(ny,nx) == true && a[ny][nx] == 1 && d[ny][nx] == 0){
					d[ny][nx] =d[y][x] + 1;
					q.add(new Pair(ny,nx));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		a = new int[n][m]; d = new int[n][m];

		for(int i = 0 ; i < n ; ++i){
			String tmp = in.readLine();
			for(int j = 0 ; j < m ; ++j){
				a[i][j] = tmp.charAt(j) - 48;
			}
		}
		
		//d[0][0] = 1;
		//dfs(0,0);
		bfs(0,0);
		System.out.println(min);
	}
}
