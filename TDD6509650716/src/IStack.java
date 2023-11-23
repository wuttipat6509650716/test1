public interface IStack {
	
	int getsize();
	boolean IsEmpty();
	void push(Object elm)throws Exception;
	
	Object top();
	boolean IsFull();
	
	Object pop();
}
