package ex04.di.resource;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

public class MoniterViewer {
	
	private Recorder recorder;

	//@Resource(name="record2") // name
	//@Resource(name="x") // name
	//@Resource(name="r3") // id
	@Resource @Qualifier("y") // 같이 사용 가능
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		
		boolean record = Resource.class.getTypeName().contains("record1");
		System.out.println(record);
		
		System.out.println(!Resource.class.getTypeName().equals("record1"));
		System.out.println(Resource.class.getCanonicalName().equals("record1"));
		
		System.out.println(Resource.AuthenticationType.class);
		
		recorder.show();
		System.out.println(recorder);
		System.out.println("@Resource 주입");
	}
	
}
