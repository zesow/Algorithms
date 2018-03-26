import java.io.*;
import java.util.Arrays;
class Main{

	public static int n,cnt;
	public static int[] a;

	public static void swap(int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void reverse(int i,int j){
		while(i < j){
			swap(i,j);
			i++; j--;
		}
	}
	public static boolean next_permutation(){
		int i = n-1;
		while(i >= 0 && a[i] <= a[i-1])
			i--;
		if(i <= 0)
			return false;
		int j = n-1;
		while(a[j] <= a[i-1])
			j--;
		swap(i-1,j);
		reverse(i,n-1);
		return true;
	}
	public static boolean prev_permutation(){
		int i = n-1;
		while(i > 0 && a[i] >= a[i-1])
			i--;
		if(i <= 0)
			return false;
		int j = n-1;
		while(a[j] >= a[i-1])
			j--;
		swap(i-1,j);
		reverse(i,n-1);
		return true;
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(in.readLine());
		a = new int[n];
		
		String[] line = in.readLine().split(" ");
		
		if(line[0].equals("1")){
			cnt = Integer.parseInt(line[1]);
			for(int i = 0 ; i < n ; ++i)
				a[i] = i+1;

			while(--cnt > 0)
				next_permutation();
			
			for(int i = 0 ; i < n ; ++i)
				System.out.print(a[i] + " ");
		}
		else{
			for(int i = 0 ; i < n ; ++i)
				a[i] = Integer.parseInt(line[i+1]);
			cnt = 1;

			while(prev_permutation() == true)
				cnt++;

			System.out.println(cnt);
		}
	}
}
