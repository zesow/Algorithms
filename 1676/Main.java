import java.util.Scanner;

class Main{
	private static int n,cnt=0,two=0,five=0;
	public static void soinsu(int num){
        for(int i = 2 ; i * i <= num ; ++i){
            while(num % i == 0){
				if(i == 2) ++two;
				else if(i == 5) ++five;

                num /= i;
            }
        }
        if(num > 1){
				if(num == 2) ++two;
				else if(num == 5) ++five;
		}


    }
	public static void solve(){

		for(int i = n ; i > 1 ; --i){
				soinsu(i);
		}

		if(five > two)
			cnt = two;
		else
			cnt = five;
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		solve();
		System.out.println(cnt);
	}
}
		
		
