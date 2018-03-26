import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
	public static int n;
	public static int[] a,d;

	private static int go(){
		int max = 0 , biggest = a[0];
		d[0] = a[0];

		for(int i = 1; i < n ; ++i){
			max = 0;
			for(int j = 0 ; j < i ; ++j){
				if(a[i] > a[j]){
					if(d[j] > max)
						max = d[j];
				}
			}
			d[i] = max + a[i];

			if(d[i] > biggest)
				biggest = d[i];

		}

		return biggest;

	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		d = new int[n];

		String[] line = in.readLine().split(" ");
		for(int i = 0 ; i < n ; ++i){
			a[i] = Integer.parseInt(line[i]);
		}

		sb.append(go());
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
