import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair implements Comparable<Pair>{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return x + " " + y;
	}

	public int compareTo(Pair comparePair){
		int compareX = comparePair.x;
		int compareY = comparePair.y;

		if(this.x == compareX)
			return this.y - compareY;

		return this.x - compareX;
	}
}
class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		
		Pair[] pairs = new Pair[n];

		for(int i = 0 ; i < n ; ++i){
			String[] line = in.readLine().split(" ");
			pairs[i] = new Pair(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
		}

		Arrays.sort(pairs);

		for(Pair pair : pairs)
			System.out.println(pair);
	}
}
