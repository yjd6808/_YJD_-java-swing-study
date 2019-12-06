package day03;

@FunctionalInterface
interface ActionListener {
	public void doSomething();
}

public class FunctionalInterfaceTest {
	ActionListener myListener;
	
	public FunctionalInterfaceTest() {
		myListener = new ActionListener() {
			@Override
			public void doSomething() {
				System.out.println("Hello World");
			}
		};
		
		myListener.doSomething();
		
		myListener = () -> 
		{
			System.out.println("Hello World2");
		};
		
		myListener.doSomething();
	}
	

	public static void main(String[] args) {
		new FunctionalInterfaceTest();
	}
	
}
