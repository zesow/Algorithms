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
	
	public static int cnt = 0,w,h;
	public static int[][] a,d;
	public static boolean isNotOut(int y,int x){
		if(y >= 0 && y < h && x >= 0 && x < w)
			return true;
		return false;
	}
	public static int[] ax = {0,1,1,1,0,-1,-1,-1};
	public static int[] ay = {1,1,0,-1,-1,-1,0,1};

	public static void bfs(int i,int j){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i,j));
		d[i][j] = 1;

		while(!q.isEmpty()){
			Pair p = q.remove();
			int y = p.i;
			int x = p.j;

			for(int k = 0 ; k < 8 ; ++k){
				int ny = y + ay[k];
				int nx = x + ax[k];

				if(isNotOut(ny,nx) == true && a[ny][nx] == 1 && d[ny][nx] == 0){
					q.add(new Pair(ny,nx));
					d[ny][nx] = 1;
				}
			}

		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String[] line = in.readLine().split(" ");
			w = Integer.parseInt(line[0]);
			h = Integer.parseInt(line[1]);
			if(w == 0 && h == 0)
				break;

			a = new int[h][w];
			d = new int[h][w];

			for(int i = 0 ; i < h ; ++i){
				line = in.readLine().split(" ");
				for(int j = 0 ; j < w; ++j){
					a[i][j] = Integer.parseInt(line[j]);
				}
			}

			cnt = 0;
			for(int i = 0 ; i < h ; ++i){
				for(int j = 0 ; j < w; ++j){
					if(a[i][j] == 1 && d[i][j] == 0){
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
}
