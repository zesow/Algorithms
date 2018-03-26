import java.io.*;

class Main{
	
	public static int[][] a;
	public static final int SIZE = 9;
	public static void print(){
		for(int i = 0 ; i < SIZE; ++i){
			for(int j = 0 ; j < SIZE; ++j){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static boolean check(int row,int col,int num){
		
		for(int i = 0 ; i < SIZE; ++i){
			if(a[i][col] == num)
				return false;
			if(a[row][i] == num)
				return false;
		}
		int alpha = (row / 3) * 3 ;
		int beta = (col / 3) * 3;
		for(int i = 0 + alpha ; i < 3 + alpha; ++i){
			for(int j = 0 + beta; j < 3 + beta; ++j){
				if(a[i][j] == num)
					return false;
			}
		}
		a[row][col] = num;
		return true;
	}
	public static void uncheck(int row,int col){
		a[row][col] = 0;
	}
	public static int go(int row,int col){

		if(row == SIZE){
			print();
			return 1;
		}
		
		for(int i = col ; i < SIZE ; ++i){
			if(a[row][i] == 0)
				go(row,i+1);
		}


		return 0;
	}
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = null;
		a = new int[SIZE][SIZE];
		for(int i = 0 ; i < SIZE ; ++i){
			line = in.readLine().split(" ");
			for(int j = 0 ; j < SIZE ; ++j){
				a[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		go(0);
	}
}
