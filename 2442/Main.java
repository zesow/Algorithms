import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static int n;
	private static void solve()
	{
		int m = 2 * n - 1;
		for(int i = 0 ; i < n ; ++i)
		{
			for(int j = 0 ; j < m / 2 - i ; ++j)
				System.out.print(" ");
			for(int j = 0 ; j < 2* i + 1 ; ++j)
				System.out.print("*");
			for(int j = 0 ; j < m / 2 - i ; ++j)
				System.out.print(" ");
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		solve();
	}
}
