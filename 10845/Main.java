import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Queue{
	private int[] arr;	
	private int size;
	private int idx,head;
	
	Queue(){
		arr = new int[10001];
		size = 0;
		idx = -1;
		head = 0;
	}

	public void push(int n){
		size += 1;
		idx += 1;
		arr[idx] = n;
	}

	public int pop(){
		if(size == 0)
			return -1;

		int temp = arr[head];
		head += 1;
		size -= 1;
		return temp;
	}

	public int size(){
		return size;
	}

	public int empty(){
		if(size == 0)
			return 1;
		return 0;
	}

	public int front(){
		if(size == 0)
			return -1;
		return arr[head];
	}

	public int back(){
		if(size == 0)
			return -1;
		return arr[idx];
	}
}
class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Queue queue = new Queue();

		int n = Integer.parseInt(in.readLine());

		while(n-- > 0 ){
			String[] line = in.readLine().split(" ");
			if(line[0].equals("push")){
					queue.push(Integer.parseInt(line[1]));
			}	
			if(line[0].equals("pop")){
				int temp = queue.pop();
				System.out.println(temp);
			}

			if(line[0].equals("size")){
				System.out.println(queue.size());
			}

			if(line[0].equals("empty")){
				System.out.println(queue.empty());
			}

			if(line[0].equals("front")){
				System.out.println(queue.front());
			}

			if(line[0].equals("back")){
				System.out.println(queue.back());
			}

		}
	}
}
