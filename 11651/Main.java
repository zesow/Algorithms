import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Arrays;

class Pair{
	int x,y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return x + " " + y;
	}

}
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		
		Pair[] pairs = new Pair[n];

		for(int i = 0 ; i < n ; ++i){
			String[] line = in.readLine().split(" ");
			pairs[i] = new Pair(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
		}

		Arrays.sort(pairs,new Comparator<Pair>(){

			public int compare(Pair pair1,Pair pair2){
				if(pair1.y == pair2.y)
					return pair1.x - pair2.x;

				return pair1.y - pair2.y;
			}
		});

		for(Pair pair : pairs)
			System.out.println(pair);
	}
}
