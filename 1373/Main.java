import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{


	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int start = s.length() % 3;
		int temp;
		if(start == 1)
		{
			temp = (s.charAt(0)-'0') * 1;
			sb.append(temp);
		}
		else if(start == 2)
		{
			temp = (s.charAt(0)-'0')*2 + (s.charAt(1)-'0') * 1;
			sb.append(temp);
		}
		for(int i = start; i < s.length(); i += 3)
		{
			temp = (s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0')*1;
			sb.append(temp);
		}
		System.out.println(sb);

	}
}
