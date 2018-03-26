import java.io.*;
import java.util.Arrays;

class Main{

	public static int l,c;
	public static char[] a;
	public static StringBuilder sb,ans;
	
	private static int cntMoeum(){
		char[] m = {'a','e','i','o','u'};
		int cnt = 0;
		for(int i = 0; i < ans.length(); ++i){
			for(int j = 0 ; j < m.length; ++j){
				if(ans.charAt(i) == m[j])
					cnt++;
			}
		}
		return cnt;
	}
	private static void go(int idx){

		ans.append(a[idx]);

		if(ans.length() == l){
			int moeum = cntMoeum();
			int jaeum = l - moeum;
			if(moeum >= 1 && jaeum >= 2){
				sb.append(ans.toString()+"\n");
			}
			return;
		}

		for(int i = idx+1 ; i < a.length; ++i){
			go(i);
			ans.deleteCharAt(ans.length()-1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();
		ans = new StringBuilder();

		String[] line = in.readLine().split(" ");
		l = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);

		a = new char[c];
		
		line = in.readLine().split(" ");
		for(int i = 0 ; i < line.length; ++i)
			a[i] = line[i].charAt(0);
		Arrays.sort(a);
		for(int i = 0 ; i < a.length; ++i){
			go(i);	
			ans.deleteCharAt(ans.length()-1);
		}

		out.write(sb.toString());

		in.close();
		out.close();
	}
}
		

