import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a,b;
		String[] line;
		while(true)
		{
			line = in.readLine().split(" ");
			if(line[0].equals("0") && line[1].equals("0")) break;
			a = Integer.parseInt(line[0]);
			b = Integer.parseInt(line[1]);

			System.out.println(a+b);

		}
	}
}
