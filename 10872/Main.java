import java.util.Scanner;

class Main{
	
	private static int n;
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		long a = 1;
		for(int i = n ; i > 1 ; --i){
			a *= i;
		}

		System.out.println(a);
	}
}
