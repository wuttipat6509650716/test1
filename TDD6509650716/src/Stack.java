public class Stack implements IStack {
	
	private int top;
	private int maxTop;
	private Object values[];

	public Stack() {
		top = -1;
		maxTop = -1;
	}
	
	Stack(int size){
		values = new Object[size];
		top = -1;
		maxTop = size - 1;
	}

	@Override
	public int getsize() {
		return maxTop+1;
	}

	@Override
	public boolean IsEmpty() { 
		return top == -1;
	}

	@Override
	public void push(Object elm) throws Exception {
        if (IsFull()) {
            throw new Exception("Error: the stack is full.");
        } else {
            if (top == -1 || values[top].getClass().equals(elm.getClass())) {
                values[++top] = elm;
            } else {
                throw new Exception("All elements in the stack must be of the same type.");
            }
        }
    }
	
	@Override
	public Object top() {
		if (IsEmpty()) {
			System.out.println("Error: the stack is empty.");
			return -1;
		} else
			return values[top];
	}

	@Override
	public boolean IsFull() {
		return top == maxTop;
	}

	@Override
	public Object pop() {
		return values[top--];
	}
	

}
