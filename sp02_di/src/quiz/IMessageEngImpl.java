package quiz;

public class IMessageEngImpl implements IMessage {

	private String hello;

	//2.setter method <--- DI
	public void setHello(String hello) {
		this.hello = hello;
	}

	@Override
	public void sayHello() {
		System.out.println(this.hello);
	}

}
