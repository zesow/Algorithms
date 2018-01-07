import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{

	private static int[] a = new int[1000001];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");

		for(int i = 0 ; i < n ; ++i){
			a[i] = Integer.parseInt(line[i]);
		}

		int max = Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i = 0 ; i < n ; ++i){
			if(a[i] > max) max = a[i];
			if(a[i] < min) min = a[i];
		}
		
		System.out.println(min + " " + max);
	}
}
