import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();

		int temp;
		String ans="";
		for(int i = 0 ; i < s.length(); ++i){
			temp = s.charAt(i) - '0';
			switch(temp){
				case 0:
					ans = "000";
					break;
				case 1:
					if(i==0) ans ="1";
					else ans = "001";
					break;
				case 2:
					if(i == 0) ans = "10";
					else ans = "010";
					break;
				case 3:
					if(i == 0) ans = "11";
					else ans = "011";
					break;
				case 4:
					ans = "100";
					break;
				case 5:
					ans = "101";
					break;
				case 6:
					ans = "110";
					break;
				case 7:
					ans = "111";
					break;
			}
			sb.append(ans);
		}
		System.out.println(sb);
	}
}
