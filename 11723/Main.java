import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{

	public static int n;
	public static int s = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		String order = null;
		int num = 0;
		n = Integer.parseInt(in.readLine());
		while(n-- > 0){
			StringTokenizer st = new StringTokenizer(in.readLine());
			order = st.nextToken();
			if(order.equals("add")){
				num = Integer.parseInt(st.nextToken());
				s |= (1<<num);
			}
			else if(order.equals("check")){
				num = Integer.parseInt(st.nextToken());
				if((int)(s & (1<<num)) > 0)
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			else if(order.equals("remove")){
				num = Integer.parseInt(st.nextToken());
				s &= ~(1<<num);
			}
			else if(order.equals("toggle")){
				num = Integer.parseInt(st.nextToken());
				s ^= (1<<num);
			}
			else if(order.equals("all")){
				s = (1<<21)-1;
			}
			else{
				s = 0;
			}
		}

		out.write(sb.toString());

		in.close();
		out.close();
	}
}
