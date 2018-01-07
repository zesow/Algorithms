import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static String solve(int x,int y)
	{
		String answer;

		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		int sum = 0;
		for(int i = 0 ; i < x-1 ; ++i)
		{

			sum += month[i];
		}
		sum += y;
		sum %= 7;

		return day[sum];
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int x = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);
		String result = solve(x,y);
		System.out.println(result);

	}
}
