import java.util.Scanner;

class Main{

	public static int[] check = new int[250000];
	public static int a,p;
	public static int nextNum(int num){
		int next = 0;
		while(num > 0){
			int temp = num % 10; num /= 10;
			next += Math.pow(temp,p);
		}
		return next;
	}
	public static void dfs(int num,int cnt){
		cnt++;
		check[num] = cnt;
		int next = nextNum(num);

		if(check[next] > 0){
			System.out.println(check[next] - 1);
			return;
		}
		dfs(next,cnt);
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt(); p = sc.nextInt();
		dfs(a,0);
	}
}
