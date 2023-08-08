package springConfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {

	private String defaulthost;
	private String host;
	
	public Client() {
		System.out.println("Client Default Constructor");
	}

	// constructor DI
	public Client(String defaulthost) {
		super();
		this.defaulthost = defaulthost;
		System.out.println("Client 생성자 : " + this.defaulthost);
	}

	// setter DI
	public void setDefaulthost(String defaulthost) {
		this.defaulthost = defaulthost;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public void send() {       /* <property name="host" value="서버" /> */
		System.out.println("Client.send() to : " + host);
	}

	// 초기화 메서드(이벤트를 내부적으로 가지고 자동 호출 : 호출시점)
	// InitializingBean 대한 구현부
	// afterPropertiesSet : property injection 후에 
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 실행");
	}
	
	// 소멸 메서드(이벤트를 내부적으로 가지고 자동 호출 : 호출시점)
	// DisposableBean 대한 구현부
	@Override
	public void destroy() throws Exception { /* ctx.colse(); */
		System.out.println("Client.destory() 실행");
	}

}
