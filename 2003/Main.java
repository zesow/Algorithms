import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		line = sc.nextLine().split(" ");
		int[] arr = new int[10001];
		for(int i = 0 ; i < n ; ++i){
			arr[i] = Integer.parseInt(line[i]);
		}

		int p1=0,p2=0;
		int sum = arr[0],ans = 0;
		while(true){
			if(p2 == n)
				break;
			if(p2 < p1){
				p2 = p1;
				sum = arr[p1];
			}

			if(sum == m){
				ans += 1;
				sum -= arr[p1];
				p1++;
			}
			if(sum > m){
				sum -= arr[p1];
				p1++;
			}
			if(sum < m){
				p2++;
				sum += arr[p2];
			}
		}

		System.out.println(ans);
	}
}
