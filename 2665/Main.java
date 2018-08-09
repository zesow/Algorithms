import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{

	private static int n,phase = 0;
	private static int[][] a,d,cp;
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
		if(i >= 0 && i < n && j >= 0 && j < n)
			return true;
		return false;
	}
	public static void print(){
		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < n ; ++j){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	public static boolean dfs(int phase,int i,int j){
		int nPhase = phase;
		boolean dresult,bresult;
		if(nPhase == 0){
			bresult = bfs();
			if(bresult == true){
				return true;
			}
		}
		else{
			for(int y = i ; y < n ; ++y){
				for(int z = j; z < n ; ++z){
					if(a[y][z] == 0){
						a[y][z] = 1;
						dresult = dfs(nPhase -1,y,z);
						a[y][z] = 0;
						if(dresult == true)
							return true;

					}
				}
			}
		}
		return false;
	}
	public static boolean bfs(){
		d = new int[n][n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));

		while(!q.isEmpty()){
			Point ptmp = q.poll();
			int i = ptmp.i;
			int j = ptmp.j;

			for(int z = 0 ; z < 4 ; ++z){
				int ni = i + ai[z];
				int nj = j + aj[z];

				if(isNotOut(ni,nj) == true && a[ni][nj] == 1 && d[ni][nj] == 0){
					d[ni][nj] = 1;
					q.add(new Point(ni,nj));
				}
			}
		}

		if(d[n-1][n-1] != 0){
			print();
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		a = new int[n][n];
		d = new int[n][n];

		for(int i = 0 ; i < n ; ++i){
			String line = in.readLine();
			for(int j = 0 ; j < line.length(); ++j){
				a[i][j] = line.charAt(j) - 48;
			}
		}
		
		phase = 0;
		int flag = 0;
		while(true){
			
			for(int i = 0 ; i < n ; ++i){
				for(int j = 0 ; j < n ; ++j){
					if(a[i][j] == 0){
						if(dfs(phase,i,j) == true){
							flag = 1;
						}
					}
					if(flag == 1)
						break;
				}
				if(flag == 1)
					break;
			}

			if(flag == 1){
				System.out.println(phase);
				break;
			}

			phase += 1;
		}

	}
}
