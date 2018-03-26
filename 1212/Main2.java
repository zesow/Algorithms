import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2{

	private static String s;
	public static StringBuilder hexToBinary(int hex,int flag){
		StringBuilder result = new StringBuilder();
		int rem;
		while(hex > 1){
			rem = hex % 2;
			hex /= 2;
			result.append(rem);
		}
		result.append(hex);
		
		if(flag != 1){
			while(result.length() < 3)
				result.append(0);
		}

		result.reverse();

		return result;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int temp;
		s = in.readLine();
		
		sb.append(hexToBinary(s.charAt(0)-48,1));

		for(int i = 1; i < s.length(); ++i){
			temp = s.charAt(i) - 48;
			sb.append(hexToBinary(temp,0));
		}

		System.out.println(sb.toString());
	}
}

