public class ArrayStack implements Stack{
	protected Object[] array = new Object[1];
	private int top = 0;
	//make top of stack equal to the item, then increment top
	public void push(Object item){
		if(top == array.length)
			grow_stack();
		array[top++] = item;
	}
	//check if stack is empty, if not return the top item in the stack and technically pop it
	public Object pop(){
		if(empty())
			return null;
		return array[--top];
	}
	//check the top of stack without removing it from array
	public Object peek(){
		if(empty())
			return null;
		return array[top-1];
	}
	//check if stack is empty
	public boolean empty(){
		if(top==0)
			return true;
		return false;
	}
	//double the stack with a temp array and copy contents over from original to temp then set original array to the temp
	private void grow_stack(){
		Object[] newarray = new Object[array.length*2];
		System.arraycopy(array, 0, newarray, 0, array.length);
		array = newarray;
	}
}