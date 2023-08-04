package quiz;

public class IMessageKoImpl implements IMessage{

	private String hello;
	
	//1.constructor <--- DI
	IMessageKoImpl(){};
	
	public IMessageKoImpl(String hello) {
		this.hello = hello;
	}

	public void sayHello() {
		System.out.println(this.hello);
	}

}
