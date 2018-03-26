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

	public static int[] ax = {0,1,0,-1};
	public static int[] ay = {1,0,-1,0};
	public static boolean isNotOut(int x,int y){
		if(x >= 0 && x < n && y>= 0 && y<n)
			return true;
		return false;
	}

	public static void print(){
		for(int i = 0 ; i < n; ++i){
			for(int j = 0 ; j < n; ++j){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(int i,int j,int cnt){
		a[i][j] = cnt;
		d[i][j] = 1;

		for(int k = 0 ; k < 4 ;++k){
			int nx = j + ax[k];
			int ny = i + ay[k];

			if(isNotOut(ny,nx) == true && a[ny][nx] == 1 && d[ny][nx] == 0)
				dfs(ny,nx,cnt);
		}
	}
	public static void bfs(int i,int j){
		Queue<Pair> q = new LinkedList<>();
		for(int k = 0 ; k < n ; ++k){
			for(int l = 0 ; l < n; ++l){
				if(a[k][l] >= 1 && d[k][l] == 0){
					q.add(new Pair(k,l));
				}
			}
		}

		while(!q.isEmpty()){
			Pair p = q.remove();
			int y = p.i;
			int x = p.j;

			for(int k = 0 ; k < 4 ; ++k){
				int ny = y + ay[k];
				int nx = x + ax[k];
				
				if(isNotOut(ny,nx) == true && a[ny][nx] == 0 && d[ny][nx] == 0){
					d[ny][nx] = d[y][x] + 1;
					a[ny][nx] = a[y][x];
					q.add(new Pair(ny,nx));
				}
			}
		}
	}
	public static int n,min = Integer.MAX_VALUE;
	public static int[][] a,d;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		a = new int[n][n]; d = new int[n][n];
		for(int i = 0 ; i < n ; ++i){
			String[] line = in.readLine().split(" ");
			for(int j = 0 ; j < n ;++j){
				a[i][j] = Integer.parseInt(line[j]);
			}
		}
		int cnt = 0;
		for(int i = 0 ; i < n ;++i){
			for(int j = 0 ; j < n ;++j){
				if(a[i][j] == 1 && d[i][j] == 0)
					dfs(i,j,++cnt);
			}
		}
		d = new int[n][n];

		bfs(0,0);
		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < n ; ++j){
				for(int k = 0; k < 4; ++k){
					int ny = i + ay[k];
					int nx = j + ax[k];
					if(isNotOut(ny,nx) == true && a[ny][nx] != a[i][j]){
						int sum = d[ny][nx] + d[i][j];
						if(min > sum)
							min = sum;
					}
				}
			}
		}
		System.out.println(min);
	}
}
