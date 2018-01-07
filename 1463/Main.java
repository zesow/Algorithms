import java.util.Scanner;

public class Main{

	public static int[] d;
	private static int go(int n){
		d = new int[n+1];

		d[1] = 0;
		for(int i = 2 ; i <= n ; ++i){

			d[i] = d[i-1] + 1;

			if(i % 2 == 0){
				if(d[i-1] > d[i/2])
					d[i] = d[i/2] + 1;
			}
			if(i % 3 == 0){
				if(d[i-1] > d[i/3])
					d[i] = d[i/3] + 1;
			}
			
		}
		return d[n];
				
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(go(n));
	}
}
