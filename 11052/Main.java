import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static int n;
	public static int[] a,d;
	
	public static void go(){
		int max = -1;
		int temp = 0;
		d[1] = a[1];
		for(int i = 2 ; i <= n ; ++i){
			for(int j = 1 ; j <= i ; ++j){
				temp = a[j] + d[i-j];
				if(temp > max)
					max = temp;
			}
			d[i] = max;
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());
		a = new int[n+1]; d = new int[n+1];
		String[] line = in.readLine().split(" ");
		for(int i = 1 ; i <= n ; ++i){
			a[i] = Integer.parseInt(line[i-1]);
		}

		go();

		out.write(sb.append(d[n]).toString());

		in.close();
		out.close();
	}
}
