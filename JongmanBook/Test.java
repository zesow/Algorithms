import java.util.*;

public class Test{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();

		System.out.println("소수 판단");
		System.out.println(Prime.isPrime(tNum));

		System.out.println("소인수분해1");
		ArrayList<Integer> factor = Prime.factorSimple(tNum);
		Iterator<Integer> iter = factor.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

		System.out.println("에라토스테네스의 체");
		boolean[] primes = Prime.eratosthenes(tNum);

		for(int i = 0 ; i < primes.length; ++i){
			System.out.println(primes[i]);
		}
	}
}
