import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution{

	public static String toPostFix(String midfix){
		Stack<Character> st = new Stack<>();
		st.push('(');
		midfix += ')';
		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < midfix.length(); ++i){
			char now = midfix.charAt(i);
			if(now == '('){
				st.push(now);
			}
			else if(now == ')'){
				while(true){
					if(st.peek() == '('){
						st.pop();
						break;
					}
					else
						sb.append(st.pop());
				}
			}
			else if(now == '*' || now == '/'){
				while(true){

					if(st.peek() == '(' || st.peek() == '+' || st.peek() == '-'){
						st.push(now);
						break;
					}
					else
						sb.append(st.pop());
				}
				
			}
			else if(now == '+' || now == '-'){
				while(true){
					if(st.peek() == '('){
						st.push(now);
						break;
					}
					else
						sb.append(st.pop());
				}

			}
			else{
				sb.append(now);
			}
		}

		return sb.toString();
	}

	public static int postCal(String postfix){
		Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i < postfix.length(); ++i){
			char now = postfix.charAt(i);
			if(now - 48 >= 0 && now - 48 < 10){
				st.push(now-48);
			}
			else{
				int b = st.pop();
				int a = st.pop();
				st.push(cal(now,a,b));
			}
		}

		return st.pop();
	}

	public static int cal(char opr, int opd1, int opd2){
		if(opr == '+'){
			return opd1 + opd2;
		}
		else if (opr == '-'){
			return opd1 - opd2;
		}
		else if(opr == '*'){
			return opd1 * opd2;
		}
		else{
			return opd1 / opd2;
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int times = 10;
		while(times-- > 0){
			int len = Integer.parseInt(in.readLine());
			String midfix = in.readLine();
			String postfix = toPostFix(midfix);
			int now = 10-times;
			sb.append("#" + now + " " + postCal(postfix)+'\n');
		}
		System.out.println(sb.toString());
	}
}
