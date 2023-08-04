package ex03.di.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoniterViewer {

	private Recorder recorder;

	//@Inject	
//	@Autowired(required = false) /*default : required = true*/
//	public MoniterViewer(@Qualifier("cord") Recorder recorder) { //constructor method, DI
//		super();
//		this.recorder = recorder;
//		System.out.println("@Autowired 자동 주입");
//	}

	@Autowired
	//@Qualifier("recorder1")
	//@Qualifier("key")
	@Qualifier("rr1")
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("3333 setRecorder method call!!!");
	}
	
	public void show() {
		recorder.show();
		System.out.println("MoniterViewer class show method call~~~");
		System.out.println("setter method MoniterViewer class show method call~~~");
	}
	
}
