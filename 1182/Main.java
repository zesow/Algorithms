import java.io.*;

class Main{


	public static int n,s,cnt = 0;
	public static int[] a;
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		s = Integer.parseInt(line[1]);
		a = new int[n];

		line =in.readLine().split(" ");
		for(int i = 0 ; i < n ; ++i)
			a[i] = Integer.parseInt(line[i]);

		for(int i = 0 ; i < (1 << n) ; ++i){
			int sum = 0;
			for(int j = 0 ; j < n ; ++j){
				if((int)(i & (1 << j)) > 0)
					sum += a[j];
			}

			if(sum == s)
				cnt++;
		}

		System.out.println(cnt);
	}
}
