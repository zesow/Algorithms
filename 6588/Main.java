import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{

	private static int n;
	private static boolean[] primes = new boolean[1000001];
	private static ArrayList<Integer> arr = new ArrayList<>();
	public static void solve(){
		primes[0] = primes[1] = true;
		for(int i = 2 ; i <= 1000000; ++i){
			if(primes[i] == false){
				arr.add(i);
				for(int j = i*2;j <= 1000000; j += i){
					primes[j] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		solve();
		while(true){
			n = Integer.parseInt(in.readLine());
			if(n == 0)
				break;
			for(int i = 0 ; i < arr.size(); ++i){
				int a = arr.get(i);
				if(primes[n-a] == false){
					System.out.println(n + " = " + a + " + " + (n-a));
					break;
				}
			}
		}
	}

}
