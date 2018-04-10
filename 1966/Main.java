import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main{
	
	public static boolean isMax(LinkedList<Integer> queue){
		for(int i = 0 ; i < queue.size(); ++i){
			if(queue.get(i) > queue.get(0))
				return false;
		}
		return true;
	}
	public static int go(int n,int m,LinkedList<Integer> queue){
		
		int cnt = 0,pointer = m;
		while(!queue.isEmpty()){
			if(isMax(queue) == true){
				cnt++;
				queue.poll();
				if(pointer == 0)
					return cnt;
			}
			else{
				queue.add(queue.poll());
			}

			if(pointer == 0)
				pointer = queue.size()-1;
			else
				pointer--;
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(in.readLine());
		int n,m;
		LinkedList<Integer> queue = null;
		while(t-- > 0){
			queue = new LinkedList<>();
			String[] line = in.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			line = in.readLine().split(" ");
			for(int i = 0 ; i < n; ++i){
				queue.add(Integer.parseInt(line[i]));
			}

			System.out.println(go(n,m,queue));
		}
	}
}
