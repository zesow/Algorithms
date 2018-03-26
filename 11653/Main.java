import java.util.Scanner;

class Main{
	private static int n;
	public static void solve(){
		for(int i = 2 ; i * i <= n ; ++i){
			while(n % i == 0){
				System.out.println(i);
				n /= i;
			}
		}
		if(n > 1)
			System.out.println(n);
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		solve();
	}
}

