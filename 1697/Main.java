import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Main{
	
	private static int n,k;
	private static int[] a = new int[100001];
	public static void bfs(){
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int min = 100001;
		while(!q.isEmpty()){
			int idx = q.poll();
			int ctx = a[idx];
			if(idx == k){
				System.out.println(ctx);
				break;
			}
			if(idx-1 >= 0 && a[idx-1] ==0){
				a[idx-1] = ctx+1;
				q.add(idx-1);
			}
			if(idx+1 <= 100000 && a[idx+1] ==0){
				a[idx+1] = ctx +1;
				q.add(idx+1);
			}
			if(idx*2 <= 100000 && a[idx*2] ==0){
				a[idx*2] = ctx +1;
				q.add(idx*2);
			}
		}
		//System.out.println(a[k]);
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		
		n= Integer.parseInt(line[0]);
		k= Integer.parseInt(line[1]);
		
		bfs();
	}
}
