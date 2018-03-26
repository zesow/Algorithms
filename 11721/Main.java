import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String sentence = in.readLine();

		int sumIdx = 0;
		int len = sentence.length();

		while(sumIdx + 10 < len){
			sb.append(sentence.substring(sumIdx,sumIdx+10)+"\n");
			sumIdx += 10;
		}
		sb.append(sentence.substring(sumIdx));

		out.write(sb.toString());

		in.close();
		out.close();
	}
}
