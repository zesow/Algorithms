import java.io.*;

class Main{

	public static int n;
	public static int[] a;

	public static void swap(int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void reverse(int i,int j){
		int cnt = (j-i) / 2 + 1;
		int tmp_i = i,tmp_j = j;
		int temp;
		for(int k = 0 ; k < cnt ; ++k){
			swap(tmp_i,tmp_j);
			tmp_i++;
			tmp_j--;
		}
	}
	public static boolean nextPermutation(){
		int i = -1,j = 0;
		for(int z = 1 ; z < n ; ++z){
			if(a[z-1] < a[z])
				i = z;
		}

		if(i == -1)
			return false;

		for(int y = i; y < n ; ++y){
			if(a[i-1] < a[y])
				j = y;
		}
		swap(i-1,j);
		reverse(i,n-1);

		return true;
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(in.readLine());
		String[] line = in.readLine().split(" ");

		a = new int[n];

		for(int i = 0 ; i < n ; ++i)
			a[i] = Integer.parseInt(line[i]);

		if(nextPermutation() == false)
			System.out.println(-1);
		else{
			for(int i = 0 ; i < n ; ++i)
				System.out.print(a[i] + " ");
		}
	}
}
