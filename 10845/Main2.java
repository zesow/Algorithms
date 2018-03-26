import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Queue{
	private int[] arr;	
	private int front,rear;
	private int size;
	
	Queue(int size){
		this.size = size;
		arr = new int[size + 1];
		front = 0;
		rear = 0;
	}

	public void push(int n){
		rear = (rear+1) % size;
		arr[rear] = n;
	}

	public int pop(){
		if(empty() == 1)
			return -1;

		front = (front+1) % size;
		return arr[front];
	}

	public int size(){
		return rear-front;
	}

	public int empty(){
		if(front == rear)
			return 1;
		return 0;
	}

	public int front(){
		if(empty() == 1)
			return -1;
		int temp = (front+1) % size;
		return arr[temp];
	}

	public int back(){
		if(empty() == 1)
			return -1;
		return arr[rear];
	}
}
class Main2{

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		

		int n = Integer.parseInt(in.readLine());
		Queue queue = new Queue(n);

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
