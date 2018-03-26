import java.util.HashMap;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int max = -1;
		long maxNum = 0;
		int cnt = 0;

		for(int i = 0 ; i < n ; ++i){
			long temp = sc.nextLong();
			if(map.get(temp) == null){
				cnt = 1;
			}
			else{
				cnt = map.get(temp) + 1;
			}
			map.put(temp,cnt);
			if(cnt > max || (cnt == max && temp < maxNum)){
				max = cnt;
				maxNum = temp;
			}
		}

		System.out.println(maxNum);


	}
}
