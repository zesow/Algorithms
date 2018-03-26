import java.util.Scanner;

class Stack{
	private int top;
	private int[] arr;
	private static final int SIZE = 10000;
	public Stack(){
		arr = new int[SIZE];
		top = -1;
	}

	public void push(int x){
		if(top == SIZE)
			return;

		top += 1;
		arr[top] = x;
	}

	public int pop(){
		if(top == -1)
			return -1;

		int temp = top;
		top -= 1;

		return arr[temp];
	}

	public int size(){
		return top+1;
	}

	public int empty(){
		if(top == -1)
			return 1;

		return 0;
	}

	public int top(){
		if(top == -1)
			return -1;

		return arr[top];
	}

}

class Main{
	public static void main(String[] args) throws Exception{

		Stack stk = new Stack();
		Scanner sc = new Scanner(System.in);

		String[] line = null;
		int n = sc.nextInt();

		while(n-- > -1){
			line = sc.nextLine().split(" ");
		

		if(line[0].equals("push")){
			stk.push(Integer.parseInt(line[1]));
		}

		if(line[0].equals("top")){
			System.out.println(stk.top());
		}
		if(line[0].equals("size")){
			System.out.println(stk.size());
		}
		if(line[0].equals("empty")){	
			System.out.println(stk.empty());
		}
		if(line[0].equals("pop")){
			System.out.println(stk.pop());
		}
		}
	}
}
