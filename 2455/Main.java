import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0, max = -1;
		for(int i = 0 ; i < 4 ; ++i){
			String[] line = in.readLine().split(" ");
			int in_ = Integer.parseInt(line[1]);
			int out = Integer.parseInt(line[0]);

			sum += in_;
			sum -= out;

			if(sum > max)
				max = sum;
		}

		System.out.println(max);
	}
}
