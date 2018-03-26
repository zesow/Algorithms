import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Main2{
	private static ArrayList<Integer> list;
	private static int n,b;
	public static StringBuilder sb;
	public static char toAlphabet(int i){
		if(i >= 10)
			return (char)(i + 55);

		return (char)(i + 48);
	}
	public static void changeBase(int a){
		if(a < b){
			list.add(a);
			return;
		}

		list.add(a % b);
		changeBase(a / b);
	}
	public static void makeResult(){
		int temp;
		for(int i = list.size() - 1 ; i >= 0 ; --i){
			temp = list.get(i);
			sb.append(toAlphabet(temp));
		}
	}
	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] line = in.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		b = Integer.parseInt(line[1]);
		
		list = new ArrayList<>();
		changeBase(n);
		makeResult();

		System.out.println(sb.toString());
	}
}
