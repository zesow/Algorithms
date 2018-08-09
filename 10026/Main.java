import java.io.BufferedReader;
import java.io.InputStreamReader;



class Main{

	private static int n;
	private static char[][] a;
	private static int[][] d_normal,d_weakness;
	private static int[] ai = {1,0,-1,0};
	private static int[] aj = {0,1,0,-1};
	public static void dfs_normal(int i,int j , int cnt){
		
		d_normal[i][j] = cnt;
		for(int k = 0 ; k < 4 ; ++k){
			int ni = i + ai[k];
			int nj = j + aj[k];

			if(isNotOut(ni,nj) == true && a[ni][nj] == a[i][j] && d_normal[ni][nj] == 0){
				dfs_normal(ni,nj,cnt);
			}
		}
	}
	public static void dfs_weakness(int i,int j,int cnt){
		d_weakness[i][j] = cnt;
		for(int k = 0 ; k < 4 ; ++k){
			int ni = i + ai[k];
			int nj = j + aj[k];

			if(isNotOut(ni,nj) == true && d_weakness[ni][nj] == 0){
				if(a[i][j] == 'R' || a[i][j] == 'G'){
					if(a[ni][nj] == 'R' || a[ni][nj] == 'G'){
						dfs_weakness(ni,nj,cnt);
					}
				}
				else{
					if(a[ni][nj] == 'B')
						dfs_weakness(ni,nj,cnt);
				}
			}
		}
	}
	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < n && j >= 0 && j < n)
			return true;
		return false;
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());

		a = new char[n][n];
		d_normal = new int [n][n];
		d_weakness = new int [n][n];
		
		int normal_cnt = 0;
		int weakness_cnt = 0;
		for(int i = 0 ; i < n ; ++i){
			String line = in.readLine();
			for(int j = 0 ; j < n; ++j){
				a[i][j] = line.charAt(j);
			}
		}

		for(int i = 0; i < n; ++i){
			for(int j = 0 ; j < n ; ++j){
				
				if(d_normal[i][j] == 0){
					normal_cnt += 1;
					dfs_normal(i,j,normal_cnt);
				}
				if(d_weakness[i][j] == 0){
					weakness_cnt += 1;
					dfs_weakness(i,j,weakness_cnt);
				}
			}

		}

		System.out.println(normal_cnt + " " + weakness_cnt);


	}
}
