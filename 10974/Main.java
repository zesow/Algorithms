import java.io.*;

class Main{

	public static int n;
	public static int[] a;

	public static void swap(int x,int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static void reverse(int x,int y){
		while(y > x){
			swap(x,y);
			++x; --y;
		}
	}

	public static boolean next_permutation(){
		int i = n-1;

		while(i > 0 && a[i-1] >= a[i])
			i -= 1;

		if( i <= 0)
			return false;
		
		int j = n-1;
		while(a[j] <= a[i-1])
			j -= 1;

		swap(i-1,j);
		reverse(i,n-1);

		return true;
	}
	public static void append(StringBuilder sb){
		for(int i = 0 ; i < n ; ++i)
			sb.append(a[i] + " " );
		sb.append("\n");
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());

		a = new int[n];
		for(int i = 0 ; i < n ; ++i){
			a[i] = i+1;
		}

		append(sb);
		while(next_permutation() == true){
			append(sb);
		}

		out.write(sb.toString());

		in.close();
		out.close();
	}
}
