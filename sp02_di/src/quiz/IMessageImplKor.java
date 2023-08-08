package quiz;

public class IMessageImplKor implements IMessage {  //
	
	String name, greeting;
	
	public IMessageImplKor() { }
	//1. constructor <----- DI
	public IMessageImplKor(String name, String greeting) {
		super();
		this.name = name;
		this.greeting = greeting;
	}

	//2. setter method <------ DI
	public void setName(String name) {
		this.name = name;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public void sayHello() {
		System.out.println(greeting + " /  " + name + "!!!");
	}

	@Override
	public String sayMessage() {
		return greeting;
	}

}
