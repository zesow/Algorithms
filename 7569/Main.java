import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{

	private static int m,n,h;
	private static int[][][] a,d;
	private static int[] ah = {1,-1};
	private static int[] ai = {1,0,-1,0};
	private static int[] aj = {0,1,0,-1};

	public static boolean isNotOut(int he,int i,int j){
		if(he >= 0 && he < h && i >= 0 && i < n && j >= 0 && j < m)
			return true;
		return false;
	}
	
	private static class 3dPoint{
		int he,i,j;

		3dPoint(int he,int i,int j){
			this.he = he;
			this.i = i;
			this.j = j;
		}
	}

	private static Queue<3dPoint> q = new LinkedList<>();
	public static void bfs(){
		
		while(!q.isEmpty()){
			3dPoint ptmp = q.poll();
			int he = ptmp.he;
			int i = ptmp.i;
			int j = ptmp.j;
			
			for(int k = 0 ; k < 4 ; ++k){
				int ni = i + ai[k];
				int nj = j + aj[k];

				if(isNotOut(he,ni,nj) == true && a[he][ni][nj] == 0){
					a[he][ni][nj] = a[he][i][j] + 1;
					q.add(new 3dPoint(he,ni,nj));
				}
			}

			for(int k = 0 ; k < 2; ++k){
				int nhe = he + ah[k];
				
				if(isNotOut(nhe,i,j) == true && a[nhe][i][j] == 0){
					a[nhe][i][j] = a[he][i][j] + 1;
					q.add(new 3dPoint(nhe,i,j));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		m = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);
		h = Integer.parseInt(line[2]);

		a = new int[h][n][m];
		d = new int[h][n][m];
		
		for(int i = 0 ; i < h ; ++i){
			for(int j = 0 ; j < n ; ++j){
				line = in.readLine().split(" ");

				for(int k = 0 ; k < m ; ++k){
					a[i][j][k] = Integer.parseInt(line[k]);
					if(a[i][j][k] == 1)
						q.add(new 3dPoint(i,j,k));
				}
			}
		}

		bfs();

		int max = 0;
		int flag = 0;
		for(int i = 0 ; i < h ; ++i){
			for(int j = 0 ; j < n ; ++j){
				for(int k = 0 ; k < m ; ++k){
					if(a[i][j][k] == 0){
						flag = 1;
						max = -1;
						break;
					}

					if(a[i][j][k] > max)
						max = a[i][j][k];
				}
				if(flag == 1)
					break;
			}
			if(flag == 1)
				break;
		}
		
		if(max != -1 )
			max -= 1;
		System.out.println(max);
	}
}

