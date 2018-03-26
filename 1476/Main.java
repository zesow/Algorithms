import java.io.*;

class Main{

	public static int e,s,m;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");

		e = Integer.parseInt(line[0]);
		s = Integer.parseInt(line[1]);
		m = Integer.parseInt(line[2]);

		int tmp_e,tmp_s,tmp_m;
		int count = 1;
		while(true){
			tmp_e = count % 15;
			tmp_s = count % 28;
			tmp_m = count % 19;
			if(tmp_e == 0)
				tmp_e = 15;
			if(tmp_s ==0)
				tmp_s = 28;
			if(tmp_m == 0)
				tmp_m = 19;
			

			if(e == tmp_e && s == tmp_s && m == tmp_m){
				System.out.println(count);
				break;
			}
			count++;
		}
	}
}
