import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	
	private static int a,b,g;
	public static int gcd(int a,int b){
		if(b == 0)
			return a;

		return gcd(b,a%b);
	}

	public static int lcm(int a,int b){
		return g * (a/g) * (b/g);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] line = in.readLine().split(" ");
		a = Integer.parseInt(line[0]);
		b = Integer.parseInt(line[1]);
		
		g = gcd(a,b);
		sb.append(g + "\n");
		sb.append(lcm(a,b));

		out.write(sb.toString() +"\n");

		in.close();
		out.close();
	}
}

