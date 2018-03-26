import java.io.*;
import java.util.ArrayList;

class Main{

	public static int k;
	public static int[] s;
	public static ArrayList<Integer> arr;
	public static StringBuilder sb;
	
	public static void apd(){
		for(int i = 0 ; i < arr.size() ; ++i){
			sb.append(arr.get(i) + " ");
		}
		sb.append('\n');
	}

	public static void go(int idx){
		

		for(int i = idx; i < k; ++i){
			arr.add(s[i]);
			if(arr.size() == 6){
				apd();
				return;
			}
			go(i+1);
			arr.remove(arr.size()-1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		while(true){
			String[] line = in.readLine().split(" ");
			k =Integer.parseInt(line[0]);
			if(k == 0)
				break;

			arr = new ArrayList<>();
			s = new int[k];
			for(int i = 0 ; i < k ; ++i){
				s[i] = Integer.parseInt(line[i+1]);		
			}
			go(0);
			sb.append('\n');
		}
		out.write(sb.toString());

		in.close();
		out.close();
	}
}
