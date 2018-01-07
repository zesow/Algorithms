import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{
	public static long n,m,arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line = in.readLine().split(" ");
		n = Long.parseLong(line[0]);
		m = Long.parseLong(line[1]);
		arr = new long[(int)n];

		line = in.readLine().split(" ");
		for(int i = 0 ; i < n ; ++i){
			arr[i] = Long.parseLong(line[i]);
		}
		
		out.write(lowerBound(0,2000000000)+ "");

		out.close();
		in.close();
	}

	private static long lowerBound(long front,long rear){
		long mid = 0 , sum = 0;
		while(front <= rear){
			mid = (front + rear) / 2;

			sum = length(mid);
			System.out.println("나무의합 :" + sum + "front : "+ front + ",rear : " + rear); 
			if(sum < m){
				rear = mid - 1;
			}
			else{
				front = mid + 1;
			}
		}
		return rear;
	}

	private static long length(long mid){

		long sum = 0;

		for(int i = 0 ; i < n; ++i){
			if(arr[i] - mid > 0)
				sum += arr[i] - mid;
		}

		return sum;
	}
}
