import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static int[] a = new int[101];
	private static int n,sum;
	private static int gcd(int x,int y)
	{
		if(x % y == 0)
			return y;

		return gcd(y,x%y);
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String[] line;
		for(int i = 0 ; i < t ; ++i){

			a = new int[101];
			sum = 0; n = 0;

			line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);

			for(int j = 0 ; j < n ; ++j)
			{
				a[j] = Integer.parseInt(line[j+1]);
			}
			
			int x,y;
			for(int j = 0; j < n-1 ; ++j)
			{
				x = a[j];
				for(int k = j+1; k < n ; ++k)
				{
					y = a[k];
					sum += gcd(x,y);
				}
			}
			System.out.println(sum);
		}
	}

}

