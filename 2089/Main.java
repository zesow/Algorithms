import java.util.Scanner;

class Main{

	private static int n;
	private static final int NUM = -2;
	private static StringBuilder sb = new StringBuilder();

	public static void solve(int n){
		if(n == 1){
			sb.append(1);
			return;
		}
		if(n > 0){
			solve(n / NUM);
			sb.append(n % NUM);
		}
		else{
			if(n % NUM == 0){
				solve(n / NUM);
				sb.append(n % NUM);
			}
			else{
				solve(n / NUM + 1);
				sb.append(1);
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if(n == 0)
			sb.append(0);
		else
			solve(n);
		System.out.println(sb.toString());
	}
}

