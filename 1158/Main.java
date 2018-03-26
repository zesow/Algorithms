import java.util.Scanner;

class Node{
	public Node prev,next;
	public int data;
	Node(){
		prev = null;
		next = null;
		data = 0;
	}
}

class LinkedList{
	private Node head,tail,cur;
	int numOfData;
	LinkedList(){
		head = tail = cur = null;
		numOfData = 0;
	}

	public void add(int n){
		Node newNode = new Node();
		newNode.data = n;
		if(numOfData == 0){
			head = tail = cur = newNode.prev = newNode.next = newNode;
		}
		else{
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
			head.prev = tail;
		}
		numOfData++;
	}

	public int get(int m){
		int result;

		for(int i = 0 ; i < m ; ++i){
			cur = cur.next;
		}

		result = cur.data;
		Node temp = cur;
		if(cur == head)
			head = cur.next;
		if(cur == tail)
			tail = cur.prev;

		Node temp_next = cur.next;
		cur = cur.prev;
		temp.next = temp.prev = null;

		cur.next = temp_next;
		temp_next.prev = cur;

		numOfData--;
		return result;
	}
}
class Main{
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		LinkedList list= new LinkedList();
		
		for(int i = 0; i < n; ++i){
			list.add(i+1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for(int i = 0 ; i < n; ++i){
			int temp;
			if(i == 0)
				temp = list.get(m-1);
			else
				temp = list.get(m);
			sb.append(temp);
			if(i != n-1)
				sb.append(", ");
		}
		sb.append('>');
		
		System.out.println(sb.toString());
	}
}
