import java.util.ArrayList;
import java.util.Arrays;
public class Prime{

	public static boolean isPrime(int n){
		if( n <= 1)
			return false;
		if(n == 2 )
			return true;

		if(n % 2 == 0 )
			return false;

		int sqrtn = (int)Math.sqrt(n);

		for(int div = 3; div <= sqrtn ; div += 2){
			if(n % div == 0)
				return false;
		}

		return true;
	}

	public static ArrayList<Integer> factorSimple(int n){
		
		ArrayList<Integer> ret = new ArrayList<>();

		int sqrtn = (int)Math.sqrt(n);

		for(int div = 2 ; div <= sqrtn; ++div){
			while(n % div == 0){
				n /= div;
				ret.add(div);
			}
		}

		if(n > 1) ret.add(n);

		return ret;
	}

	public static boolean[] eratosthenes(int n){
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes,true);

		primes[0] = primes[1] = false;
		int sqrtn = (int)Math.sqrt(n);

		for(int i = 2; i <= sqrtn ; ++i){
			if(primes[i] == true){
				for(int j = i*i; j <= n ; j += i)
					primes[j] = false;
			}
		}

		return primes;
	}

}
