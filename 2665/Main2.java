import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main2{

	private static int n;
	private static int[][] a;
	private static Memo[][] d;

	private static class PointCnt{
		int i,j,cnt;
		PointCnt(int i,int j,int cnt){
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	private static class Memo{
		int cnt,dist;
		Memo(int cnt,int dist){
			this.cnt = cnt;
			this.dist = dist;
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
				System.out.print(d[i][j].cnt + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	public static void bfs(PointCnt start){
		Queue<PointCnt> q = new LinkedList<>();
		q.add(start);

		while(!q.isEmpty()){
			PointCnt ptmp = q.poll();
			int i = ptmp.i;
			int j = ptmp.j;
			int cnt = ptmp.cnt;
			// System.out.println(cnt + ", " + d[i][j].cnt);
			for(int k = 0 ; k < 4; ++k){
				int ni = i + ai[k];
				int nj = j + aj[k];
				
				if(isNotOut(ni,nj) == true){
					if(a[ni][nj] == 1){
						if(d[ni][nj].dist == 0 || d[ni][nj].cnt > cnt){
							d[ni][nj] = new Memo(cnt,d[i][j].dist + 1);
							q.add(new PointCnt(ni,nj,cnt));
						}
						else{
							if(d[ni][nj].cnt == cnt){
								if(d[ni][nj].dist > d[i][j].dist + 1){
									d[ni][nj].dist = d[i][j].dist + 1;
									q.add(new PointCnt(ni,nj,cnt));
								}
							}
						}
					}
					else{
						if(d[ni][nj].dist == 0 || d[ni][nj].cnt > cnt + 1){
							d[ni][nj] = new Memo(cnt+1,d[i][j].dist+1);
							q.add(new PointCnt(ni,nj,cnt+1));
						}
						else{
							if(d[ni][nj].cnt == cnt + 1){
								if(d[ni][nj].dist > d[i][j].dist + 1){
									d[ni][nj].dist = d[i][j].dist + 1;
									q.add(new PointCnt(ni,nj,cnt+1));
								}
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		a = new int[n][n];
		d = new Memo[n][n];

		for(int i = 0 ; i < n ; ++i){
			String line = in.readLine();
			for(int j = 0 ; j < line.length(); ++j){
				a[i][j] = line.charAt(j) - 48;
				d[i][j] = new Memo(0,0);
			}
		}

		bfs(new PointCnt(0,0,0));
		print();	
		System.out.println(d[n-1][n-1].cnt);
	}
}
