package ex04.di.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

public class MoniterViewer {
	
	private Recorder recorder;   // has-a

	@Resource (name = "z") 
//	@Resource(name = "x")  // name
//	@Resource(name = "r3")   // id
//	@Resource   @Qualifier("y")  // 같이 사용 가능
//	public void setRecorder(@Qualifier("y") Recorder recorder) {   // DI
	public void setRecorder(Recorder recorder) {   // DI
		this.recorder = recorder;
		
		boolean record = Resource.class.getTypeName().contains("record1");
		System.out.println(record);
		
		System.out.println(!Resource.class.getTypeName().equals("record1"));
		System.out.println(Resource.class.getCanonicalName().equals("record1"));
		
		System.out.println(Resource.AuthenticationType.class);
		
		
		recorder.show();
		System.out.println(recorder);
		System.out.println("222 @Resource 주입");
	}
	
	

}
