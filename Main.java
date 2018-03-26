import java.io.*;

class Main{

	public static int n,m;
	public static boolean[] button;
	public static int possible(int i){
		int len = 0;
		if(i == 0 && button[0] == false)
			return 1;
		while(i > 0){
			int tmp = i % 10; i /= 10;
			len++;
			if(button[tmp] == true)
				return 0;
		}

		return len;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		String[] line = null;
		button = new boolean[10];
		if(m != 0){
			line = in.readLine().split(" ");
			for(int i = 0 ; i < line.length;++i){
				button[Integer.parseInt(line[i])] = true;
			}
		}
		int original = Math.abs(n - 100);
		int min = Integer.MAX_VALUE;
		int len;
		for(int i = 0 ; i <= 1000000; ++i){
			if(possible(i) > 0){
				len = possible(i);
				if(Math.abs(n-i) + len < min){
					min = Math.abs(n-i) + len;
				}
			}
		}
		int winner = original > min? min : original;
		System.out.println(winner);
	}
}
