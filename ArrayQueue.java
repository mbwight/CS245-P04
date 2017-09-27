public class ArrayQueue implements Queue{
	protected int head;
	protected int tail;
	protected Object[] array = new Object[1];
	//initialize the queue with head and tail starting at 0
	public ArrayQueue(){
		head = 0;
		tail = 0;
		
	}
	//to dequeue a queue, check if the queue is empty first. If it isnt, return current head and increment so new head is next in line
	public Object dequeue(){
		if(empty())
			return null;
		Object item = array[head];
		head++;
		if(head == array.length)
			head = 0;
		return item;
	}
	//I just used a peek for queue to debug 
	/*public Object peep(){
		return array[head];
	}
	*/
	
	//take item input, check if full and if so double queue size. If it isnt full, make item at current tail position then
	//move tail to next position where it points to the next point in the queue
	public void enqueue(Object item){
		if(full())
			grow_queue();
		array[tail++] = item;
		if(tail==array.length)
			tail = 0;
		
	}
	//if the head and tail are the same value the queue is empty
	public boolean empty(){
		if(head==tail)
			return true;
		return false;
	}
	//if the queue is full, tail+1 will be divisible fully by the array length and equal 0(head)
	public boolean full(){
		if((tail+1)%array.length == head)
			return true;
		return false;
	}
	//takes a temp array that is double the size of current array
	//if the tail wraps around, use special procedure to arraycopy the head section first, then wrap around to the tail
	//also have to reset the head and the tail
	private void grow_queue(){
		Object [] newarray = new Object[array.length*2];
		int oldtail;
		if(tail<head){
			System.arraycopy(array, head, newarray, 0, array.length-head);
			System.arraycopy(array, tail, newarray, array.length-head, head-tail);
			oldtail = array.length-(head-tail);
			array = newarray;
			head = 0;
			tail = oldtail;
			
		}
		else
			System.arraycopy(array, 0, newarray, 0, array.length);
			array = newarray;
	}
	
	
}
