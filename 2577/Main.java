import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		int[] nums = new int[10];
		a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
		long result = a*b*c;
		String s = Long.toString(result);
		for(int i = 0 ; i < s.length(); ++i){
			int now = s.charAt(i) - 48;
			nums[now] += 1;
		}

		for(int i = 0 ; i < 10 ; ++i){
			System.out.println(nums[i]);
		}
	}
}
