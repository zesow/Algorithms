import java.util.Scanner;
import java.util.ArrayList;

class Main{

	public static int n;
	public static int count = 0;
	public static ArrayList<Integer> arr;

	public static boolean isCorrect(int y,int x){

		for(int i = 0 ; i < arr.size(); ++i){
			if(arr.get(i) == x)
				return false;
			if(Math.abs(arr.get(i)-x) == Math.abs(i-y))
				return false;
		}

		return true;
	}
	public static void go(int y,int x){
		if(y == n){
			count++;
			return;
		}

		for(int i = 0 ; i < n ; ++i){
			if(isCorrect(y,i) == true){
				arr.add(i);
				go(y+1,i);
				arr.remove(y);
			}
		}

	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new ArrayList<>();
		go(0,0);
		System.out.println(count);
	}

}

