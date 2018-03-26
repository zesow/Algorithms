import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main{
	
	private static int a, b,m;
	private static int[] arr;

	private static StringBuilder sb = new StringBuilder();

	public static int aToDec(){
		int result = 0;

		for(int i = 0 ; i < arr.length; ++i){
			result += arr[i] * Math.pow(a,arr.length-(i+1));
		}

		return result;
	}

	public static void decToB(int decimal){
		if(decimal < b){
			sb.append(decimal);
			sb.append(" ");
			return;
		}

		decToB(decimal / b);
		sb.append(decimal % b);
		sb.append(" ");
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		a = Integer.parseInt(line[0]);
		b = Integer.parseInt(line[1]);

		m = Integer.parseInt(in.readLine());

		arr = new int[m];

		line = in.readLine().split(" ");
		for(int i = 0 ; i < m ; ++i)
			arr[i] = Integer.parseInt(line[i]);

		int decimal = aToDec();
		decToB(decimal);

		System.out.println(sb.toString());

	}
}
