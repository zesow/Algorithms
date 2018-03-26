import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	
	public static boolean prime(int n){
		if(n < 2)
			return false;

		for(int i = 2 ; i*i <= n; ++i){
			if(n % i == 0)
				return false;
		}

		return true;
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] line = in.readLine().split(" ");
		int count = 0;

		for(int i = 0 ; i < n ; ++i){
			if(prime(Integer.parseInt(line[i])) == true)
				count++;
		}

		System.out.println(count);
	}
}
	
