import java.io.*;
import java.util.ArrayList;

class Main{

	public static final int[] ay = {1,0,-1,0};
	public static final int[] ax = {0,1,0,-1};

	public static int r,c;
	public static char[][] a;
	public static int max = -1;
	public static ArrayList<Character> arr = new ArrayList<>();
	public static boolean isOut(int y,int x){
		if(y < 0 || y >= r || x < 0 || x >= c)
			return true;

		return false;
	}
	public static boolean isFirst(char c){
		for(int i = 0 ; i < arr.size(); ++i){
			if(arr.get(i) == c)
				return false;
		}

		return true;
	}
	public static void go(int y,int x,int num){
		int flag = 0;
		int nx,ny;

		arr.add(a[y][x]);

		for(int i = 0 ; i < 4 ; ++i){
			ny = y + ay[i];
			nx = x + ax[i];
			if(isOut(ny,nx) == false && isFirst(a[ny][nx]) == true){
				go(ny,nx,num+1);
			}
			else
				flag++;
		}

		if(flag == 4){
			if(num > max)
				max = num;
		}

		arr.remove(arr.size()-1);

		return;
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line = in.readLine().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		a = new char[r][c];
		for(int i = 0 ; i < r ; ++i){
			String l = in.readLine();
			for(int j = 0 ; j < l.length(); ++j){
				a[i][j] = l.charAt(j);
			}
		}

		go(0,0,1);

		System.out.println(max);
	}
}
