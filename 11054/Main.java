import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
	public static int n;
	public static int[] a,d,d1,d2;

	private static int go(){
		d1[0] =1;
		d2[n-1] = 1;
		int max1 = 0, max2 = 0;
		for(int i = 1; i < n ; ++i){
			max1 = 0;
			for(int j = 0; j < i ; ++j){
				if(a[i] > a[j]){
					if(d1[j] > max1)
						max1 = d1[j];
				}	
			}
			d1[i] = max1 + 1;
		}

		for(int i = n-2; i >= 0; --i){
			max2 = 0;
			for(int j = n-1; j > i ; --j){
				if(a[i] > a[j]){
					if(d2[j] > max2)
						max2 = d2[j];
				}
			}
			d2[i] = max2 + 1;
		}

		int biggest = 0;
		for(int i = 0 ; i < n ; ++i){
			d[i] = d1[i] + d2[i] - 1;
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
		d1 = new int[n];
		d2 = new int[n];

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
