import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main{

	private static int n,m;
	private static LinkedList<Integer> a = new LinkedList<>();
	private static LinkedList<Integer> d = new LinkedList<>();
	private static LinkedList<Integer> l_arr = null;
	private static LinkedList<Integer> r_arr = null;

	public static void goLeft(LinkedList<Integer> list){
		list.addLast(list.pollFirst());
	}
	public static void goRight(LinkedList<Integer> list){
		list.addFirst(list.pollLast());
	}
	public static int left(int now){
		// 왼쪽으로 돌면서 목적지까지 갔을 때 카운트 반환	
		int cnt = 0;
		l_arr = new LinkedList<>();
		for(int i = 0 ; i < a.size(); ++i){
			l_arr.add(a.get(i));
		}
		while(true){
			if(l_arr.peek() == now)
				return cnt;
			cnt++;
			goLeft(l_arr);
		}

	}
	public static int right(int now){
		// 오른쪽으로
		int cnt = 0;
		r_arr = new LinkedList<>();
		for(int i = 0 ; i < a.size(); ++i){
			r_arr.add(a.get(i));
		}
		while(true){
			if(r_arr.peek() == now)
				return cnt;
			cnt++;
			goRight(r_arr);
		}

	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		int min = 0;

		for(int i = 0 ; i < n ; ++i){
			a.add(i);
		}

		line = in.readLine().split(" ");
		for(int i = 0; i < m ; ++i){
			d.add(Integer.parseInt(line[i]) - 1);
		}
		
		for(int i = 0 ; i < m ; ++i){
			int now = d.poll();
			int l = left(now);
			int r = right(now);
			if(l > r){
				min += r;
				a = r_arr;
			}
			else{
				min += l;
				a = l_arr;
			}
			a.poll();
		}

		System.out.println(min);
	}
}
