package ex03.di.qualifier;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoniterViewer {
	
	private Recorder recorder;   // has-a

	//@Inject    
//	@Autowired(required = false)  /* default : required = true */
//	public MoniterViewer(@Qualifier("key") Recorder recorder) {  // constructor method,   DI
//		super();
//		this.recorder = recorder;
//		System.out.println("@Autowired 자동 주입");
//	}
	
	@Autowired
//	@Qualifier("recorder4")  //  id="recorder3"   // <qualifier /> 엘리먼트가 없어야함
	@Qualifier("rr1")
//	@Qualifier("key")       // <qualifier value="key"/>
//	public void setRecorder(@Qualifier("r1")  Recorder recorder) {
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("3333 setRecorder method call!!!");
	}
	
//	@Autowired
//	public void setRecorder(@Qualifier("cord")  Recorder recorder) {
//		this.recorder = recorder;
//	}

	public void show() {
		recorder.show();
		System.out.println("MoniterViewer class show mehtod call~~~");
		System.out.println("setter method MoniterViewer class show mehtod call~~~");
	}


}
