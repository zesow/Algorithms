import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
class Main{

	public static int[][] a,d;
	public static int n,result = 1;
	public static 	ArrayList<Integer> ans = new ArrayList<>();	
	public static int[] ax = {0,1,0,-1};
	public static int[] ay = {1,0,-1,0};
	public static boolean isNotOut(int i,int j){
		if(i >= 0 && i < n && j >= 0 && j < n)
			return true;
		return false;
	}

	public static int max;
	public static void dfs(int y,int x,int cnt){
		d[y][x] = result;
		if(cnt > max)
			max = cnt;

		for(int i = 0; i < 4; ++i){
			int nx = x + ax[i];
			int ny = y + ay[i];

			if(isNotOut(ny,nx) == true && a[ny][nx] == 1 && d[ny][nx] == 0)
				dfs(ny,nx,max+1);
		}

	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		a = new int[n][n]; d = new int[n][n];

		for(int i = 0 ; i < n ; ++i){
			String line = in.readLine();
			for(int j = 0 ; j < n ; ++j){
				a[i][j] = line.charAt(j) - 48;
			}
		}

		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < n ; ++j){
				if(a[i][j] == 1 && d[i][j] == 0){
					max = 1;
					dfs(i,j,1);
					result++;
					ans.add(max);
				}
			}
		}

		Collections.sort(ans);
		System.out.println(result-1);
		for(int i = 0 ; i < ans.size(); ++i)
			System.out.println(ans.get(i));

	}
}




