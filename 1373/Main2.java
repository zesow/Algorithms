import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2{
	
	private static String n;
	private static StringBuilder sb;

	public static void solve(String s){
		// 맨 앞에 몇 개가 남는지, 그래서 어디에서부터 3개씩을 시작해야 하는지 계산한다.
		int start = s.length() % 3;
		int temp;

		if(start == 1){
			temp = (s.charAt(0) - 48) * 1;
			sb.append(temp);
		}
		else if(start == 2){
			temp = (s.charAt(0) - 48) * 2 + (s.charAt(1) - 48) * 1;
			sb.append(temp);
		}

		for(int i = start; i < s.length(); i += 3){
			temp = (s.charAt(i) - 48) * 4 + (s.charAt(i+1) - 48) * 2 + (s.charAt(i+2) - 48) * 1;
			sb.append(temp);
		}

	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = in.readLine();
		sb = new StringBuilder();
		
		solve(n);
		System.out.println(sb.toString());
	}
}

