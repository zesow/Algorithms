import java.io.*;
import java.util.Stack;

class Main{

	public static void main(String[] args) throws Exception{

	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = null;
		
		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			stack = new Stack<>();
			int cnt = 0;
			String line = in.readLine();
			for(int i = 0 ; i < line.length(); ++i){
				if(line.charAt(i) == '('){
					stack.push('(');
					cnt += 1;
				}
				else{
					cnt -= 1;
					if( cnt < 0)
						break;
					stack.pop();
				}
			}

			if(stack.empty() == true && cnt == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
