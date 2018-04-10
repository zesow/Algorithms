import java.util.Scanner;

class Main{
	private static int ans,flag = 0;
	public static void go(int num,int cnt,int sum){
		if(sum == ans){
			if(flag == 0)
				System.out.println(cnt);
			flag = 1;
			return;
		}

		if(num > ans)
			go(num/2,cnt,sum);
		
		if(sum+ num > ans)
			go(num/2,cnt,sum);
		else
			go(num/2,cnt+1,sum+num);
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		ans = sc.nextInt();
		go(64,0,0);
	}
}
