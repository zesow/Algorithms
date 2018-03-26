import java.io.BufferedReader;
import java.io.InputStreamReader;
class Node{
	Node prev,next;
	int data;

	Node(){
		prev = next =null;
		data = 0;
	}

}
class Deque{
	private Node front,rear;
	private int size;

	Deque(){
		front = rear = null;
		size = 0;
	}
	public void first_push(int x){
		Node newNode = new Node();
		newNode.data = x;
		front = rear = newNode.prev = newNode.next = newNode;
		size++;
	}
	public void push_front(int x){
		if(empty() == 1){
			first_push(x);
			return;
		}
		
		Node newNode = new Node();
		newNode.data = x;
		
		newNode.next = front;
		front.prev = newNode;
		front = newNode;

		size++;
	}

	public void push_back(int x){
		if(empty() == 1){
			first_push(x);
			return;
		}
		
		Node newNode = new Node();
		newNode.data = x;

		newNode.prev = rear;
		rear.next = newNode;
		rear = newNode;

		size++;
	}
	public int pop_front(){
		if(empty() == 1)
			return -1;
		int temp = front.data;
		front = front.next;
		size--;
		return temp;
	}

	public int pop_back(){
		if(empty() == 1)
			return -1;
		int temp = rear.data;
		rear = rear.prev;
		size--;
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
		if(empty() == 1)
			return -1;

		return front.data;
	}

	public int back(){
		if(empty() == 1)
			return -1;

		return rear.data;
	}
}

class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Deque queue = new Deque();

		while(n-- > 0){
			String[] line = in.readLine().split(" ");
			if(line[0].equals("push_front")){
				queue.push_front(Integer.parseInt(line[1]));
			}
			if(line[0].equals("push_back")){
				queue.push_back(Integer.parseInt(line[1]));
			}
			if(line[0].equals("pop_front")){
				System.out.println(queue.pop_front());
			}
			if(line[0].equals("pop_back")){
				System.out.println(queue.pop_back());
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
