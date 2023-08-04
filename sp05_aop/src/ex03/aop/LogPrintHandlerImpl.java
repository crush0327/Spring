package ex03.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintHandlerImpl implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) //인자값 1개
		throws Throwable {
		System.out.println("invoke method start!!!");
		
		//보조 업무
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간측정 시작
		log.info("타이머시작");
		
		////////주관심 실행 코드//////////////////////
		Object result = invocation.proceed();
		//////////////////////////////////////////////
		sw.stop();
		log.info("타이머 끝");
		log.info("[TimeeLog] Method : "+invocation.getMethod()); //실행한 Method 명칭
		log.info("[TimerLog] process Time:"+sw.getTotalTimeMillis()); // 작업에 걸린 시간
		
		return result;
	}

}
