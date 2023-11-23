
public class TestCase extends junit.framework.TestCase {
	
	//TC1
		public void testCreateNewEmptyStack() {
			Stack s1 = new Stack();
			assertEquals(true, s1.IsEmpty()); 
			assertEquals(0, s1.getsize());
		}
		
	//TC2
		public void testPushElementStack() {
			Stack s1 = new Stack(10);
			try {
	            s1.push(10);
	            s1.push(20);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			assertEquals(20, s1.top()); 
		}
		
	//TC3
		public void testPushExceptionStack() {
			Stack s1 = new Stack(10);
			try {
	            s1.push(10);
	            s1.push(20);
	            s1.push("Hello");
	        } catch (Exception e) {
				e.printStackTrace();
				assertEquals("All elements in the stack must be of the same type.", e.getMessage());		}
	        }
	//TC4
		public void testPushLastInFirstOut() {
			Stack s1 = new Stack(10);
			try {
	            s1.push(10);
	            s1.push(20);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			assertEquals(20, s1.pop());
			assertEquals(10, s1.pop()); 
		}
		
	//TC5
		public void testPushFullStack() {
			Stack s1 = new Stack(5);
			try {
	            s1.push(10);
	            s1.push(20);
	            s1.push(30);
	            s1.push(40);
	            s1.push(50);
	            s1.push(60);    
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	assertEquals("Error: the stack is full.", e.getMessage());
	        }
			assertEquals(50, s1.pop()); 
		}
}
