import java.util.Scanner;

class Main2{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] line = sc.nextLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int a = Integer.parseInt(line[1]);
		int b = Integer.parseInt(line[2]);
		int cnt = 0;
		while(a != b){
			cnt++;
			a = a/2 + a%2;
			b = b/2 + b%2;
		}
		System.out.println(cnt);
	}
}
