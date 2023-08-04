package ex02.di.message;

import org.springframework.beans.factory.annotation.Autowired;

public class MyApplication {
	
	private MessageService service;
	
	//@Autowired
	public MyApplication() { }   
	public MyApplication(MessageService  service) {  // DI
		this.service = service;
	}
	
	// setter method
	public void setService(MessageService service) {  // DI
		this.service = service;
	}
	
	public boolean processMessage(String msg, String rec) {
		return this.service.sendMessage(msg, rec);
	}
	
}
