import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{

	private static int m,n;
	private static boolean[] c;
	private static ArrayList<Integer> result = new ArrayList<>();
	
	public static void solve(){
		c = new boolean[1000001];

		for(int i = 2; i <= n ; ++i){
			if(c[i] == false){
				if(i >= m)
					result.add(i);
				for(int j = i * 2; j <= n; j+=i){
					c[j] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		m = Integer.parseInt(line[0]);
		n = Integer.parseInt(line[1]);

		solve();

		for(int i = 0 ; i < result.size(); ++i){
			System.out.println(result.get(i));
		}
	}
}
