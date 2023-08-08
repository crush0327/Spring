package quiz;

public class IMessageImplEng implements IMessage {
	
	String name, greeting;
	
	// setter method <----- DI	
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
