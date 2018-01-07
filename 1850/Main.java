import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static long gcd(long m,long n)
	{
		if(m % n == 0)
			return n;

		return gcd(n,m%n);
	}
	
	private static long solve(long m,long n)
	{	
		long result;
		long big,small;
		if(m > n)
		{
			big = m;small = n;
		}
		else
		{
			big = n;small = m;
		}
		if(big % small == 0)
			result = small;
		else
			result = 1;

		return result;
	}
	public static void main(String[] args) throws Exception{
		long m,n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		m = Long.parseLong(line[0]);
		n = Long.parseLong(line[1]);
		
		for(int i = 0; i < gcd(m,n); ++i){
			System.out.print('1');
		}
		System.out.println();
	}
}
