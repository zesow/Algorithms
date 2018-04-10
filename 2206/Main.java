import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Pair{
	int x,y,smash;
	Pair(int x,int y,int smash){
		this.x = x;
		this.y = y;
		this.smash = smash;
	}
}

class Main{
	private static int n,m;
	private static int[][] a;
	private static int[][][] c;
	private static int[] ax = {1,0,-1,0};
	private static int[] ay = {0,1,0,-1};
	private static Queue<Pair> q = new LinkedList<>(); 
	
	public static boolean isOut(int x,int y){
		if(x < 0 || x >= n || y < 0 || y >= m)
			return true;
		return false;
	}
	public static void bfs(){
		q.add(new Pair(0,0,0));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			int x = p.x;
			int y = p.y;
			int smash = p.smash;

			for(int i = 0 ; i < 4 ; ++i){
				int nx = x + ax[i];
				int ny = y + ay[i];
				
				if(!isOut(nx,ny)){
					if(a[nx][ny] == 0 && c[nx][ny][smash] == 0){
						c[nx][ny][smash] = c[x][y][smash] + 1;
						q.add(new Pair(nx,ny,smash));
					}
					else{
						if(smash == 0 && c[nx][ny][smash+1] == 0){
							c[nx][ny][smash+1] = c[x][y][smash] + 1;
							q.add(new Pair(nx,ny,smash+1));
						}
					}
				}
			}

			
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		a = new int[n][m];
		c = new int[n][m][2];

		for(int i = 0 ; i < n ; ++i){
			String temp = in.readLine();
			for(int j = 0 ; j < m ; ++j){
				a[i][j] = temp.charAt(j) - 48;
			}
		}
		
		bfs();
	
		if (c[n-1][m-1][0] != 0 && c[n-1][m-1][1] != 0) {
            System.out.println(Math.min(c[n-1][m-1][0], c[n-1][m-1][1]) + 1);
        } else if (c[n-1][m-1][0] != 0) {
            System.out.println(c[n-1][m-1][0] + 1);
        } else if (c[n-1][m-1][1] != 0) {
            System.out.println(c[n-1][m-1][1] + 1);
        } else {
            System.out.println(-1);
        }
	}
}
