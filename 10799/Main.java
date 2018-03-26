import java.util.Scanner;
import java.util.Stack;

class Main{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		Stack<Character> stack = new Stack<>();

		int count = 0;

		char now=0,before=0;
		for(int i = 0 ; i < line.length(); ++i){
			now = line.charAt(i);
			if(now == '(')
				stack.push('(');
			else{
				stack.pop();
				if(before == '('){
					count += stack.size();
				}
				else{
					count += 1;
				}
			}

			before = now;
		}

		System.out.println(count);
	}
}
		
