import java.util.Scanner;

class Main{

	private static long n,m;
	private static long two=0,five=0;

	public static void solve(){
		for(long i = 2 ; i<=n ; i*=2)
			two += n/i;
		for(long i = 2; i<=m; i*=2)
			two -= m/i;
		for(long i = 2; i<=(n-m); i*=2)
			two -= (n-m)/i;


		for(long i = 5 ; i<=n ; i*=5)
			five += n/i;
		for(long i = 5; i<=m; i*=5)
			five -= m/i;
		for(long i = 5; i<=(n-m); i*=5)
			five -= (n-m)/i;
	}
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		m = sc.nextLong();

		solve();

		long result = 0;
		if(two > five)
			result = five;
		else
			result = two;

		System.out.println(result);
	}
}
