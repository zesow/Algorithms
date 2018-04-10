import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] a= {0,1,2,3};
		while(n-- > 0){
			String[] line = sc.nextLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
			
		}
		//System.out.println(a[1]);	
		for(int i = 1 ; i < 4 ; ++i){
			if(a[i] == 1){
				System.out.println(i);
				break;
			}
		}
	}
}
