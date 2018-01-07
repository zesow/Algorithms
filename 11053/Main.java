import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int n;
	public static int[] a,d;
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

	private static int go(){
		int max = 0;
		int biggest = 1;
		d[0] = 1;

		for(int i = 1; i < n ; ++i){
			max = 0;
			for(int j = 0 ; j < i ; ++j){
				if(a[j] < a[i]){
					if(d[j] > max)
						max = d[j];
				}
			}
			d[i] = max +1;

			if(d[i] > biggest)
				biggest = d[i];
		}

		return biggest;
	}
}
