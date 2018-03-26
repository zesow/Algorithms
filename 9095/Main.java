import java.io.*;

class Main{

	public static int count,n,t;

	public static void go(int sum){
		if(sum == n ){
			count++;
		}
		if( sum >= n ){
			return;
		}
		
		go(sum+1); go(sum+2);go(sum+3);
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		while(t-- > 0)
		{
			n = Integer.parseInt(in.readLine());
			
			count = 0;
			go(0);

			System.out.println(count);
		}
	}
}
