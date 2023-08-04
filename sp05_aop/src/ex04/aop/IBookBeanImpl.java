package ex04.aop;

public class IBookBeanImpl implements IBookBean {

	@Override
	public void testHello(String str, int num) {
		System.out.println("public void testHello(String str, int num) call~~~~");
		System.out.println("매개변수: "+str+", "+num);	
	}

	@Override
	public int korHello(int word) {
		System.out.println("public int korHello(int word) calL~~~~");
		return word;
	}

}
