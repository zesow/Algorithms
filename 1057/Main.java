import java.util.Scanner;
import java.util.LinkedList;

class Main{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> temp = null;

		int n = Integer.parseInt(line[0]);
		int a = Integer.parseInt(line[1]);
		int b = Integer.parseInt(line[2]);
		for(int i = 1; i <= n ; ++i){
			list.add(i);
		}
		int cnt = 0;
		while(list.size() > 1){
			cnt++;
			temp = new LinkedList<>();
			for(int i = 0 ; i < list.size()-1 ; i += 2){
				int left = list.get(i);
				int right = list.get(i+1);
				if((left == a && right == b) || (left == b && right == a)){
					System.out.println(cnt);
					return;
				}
				if(left == a || left == b)
					temp.add(list.get(i));
				else
					temp.add(list.get(i+1));
			}
			if(list.size() % 2 == 1)
				temp.add(list.peekLast());
			list = temp;
			
		}
		System.out.println(-1);
	}
}
