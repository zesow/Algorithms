import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	
	private static StringBuilder sb = new StringBuilder();
	
	private static void solve(long n,int b)
	{
		char result;
		if(n < b)
		{
			if(n <10)
				result = (char)(n + 48);
			else
				result = (char)(n +55);
			sb.append(result);
			return;
		}
		if(n%b <10)
			result = (char)(n%b + 48);
		else
			result = (char)(n%b +55);

		sb.append(result);
		solve(n/b,b);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		long n = Long.parseLong(line[0]);
		int b = Integer.parseInt(line[1]);

		solve(n,b);
		sb.reverse();
		System.out.println(sb);
	}
}
