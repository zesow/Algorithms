import java.io.*;

class Node{
	public Node left,right;
	public char data;
	Node(){
		left = null;
		right = null;
		data = 0;
	}
}
class ArrayList{
	Node cursor,head,tail;
	Node dummyTail;
	int numOfData;

	ArrayList(){
		dummyTail = new Node();
		cursor = dummyTail;
		head = dummyTail;
		tail = dummyTail;
		numOfData = 0;
	}

	public void left(){
		if(cursor == head)
			return;

		cursor = cursor.left;
	}

	public void right(){
		if(cursor == tail)
			return;

		cursor = cursor.right;
	}

	public void delete(){
		if(cursor == head){
			return;
		}
		Node temp = cursor.left;
		if(temp == head){
			temp.right = null;
			cursor.left = null;
			head = cursor;
		}
		else{
			cursor.left = temp.left;
			temp.left.right = cursor;
		}
	}

	public void add(char a){
		Node newNode = new Node();
		newNode.data = a;
		numOfData++;
		newNode.left = newNode.right = null;
		
		if(cursor == head){
			newNode.right = head;
			head.left = newNode;
			head = newNode;
		}
		else{
			Node temp = cursor.left;
			newNode.left = temp;
			temp.right = newNode;
			cursor.left = newNode;
			newNode.right = cursor;
		}

	}

	public void print(){
		Node point = head;
		while(point != null && point != tail){
			System.out.print(point.data);
			point = point.right;
		}
		System.out.println();
	}
}

class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList arr = new ArrayList();

		String begin = in.readLine();
		for(int i = 0 ; i < begin.length(); ++i){
			arr.add(begin.charAt(i));
		}

		int n = Integer.parseInt(in.readLine());

		while(n-- > 0){
			String[] line = in.readLine().split(" ");
			if(line[0].equals("L")){
				arr.left();
			}
			if(line[0].equals("D")){
				arr.right();
			}
			if(line[0].equals("B")){
				arr.delete();
			}
			if(line[0].equals("P")){
				arr.add(line[1].charAt(0));
			}

		}

		arr.print();
		
	}
}

