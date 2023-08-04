package ex05.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Around Service invoke() start!!!");

		// 보조 업무
		Log log = LogFactory.getLog(this.getClass());

		StopWatch sw = new StopWatch();
		sw.start(); // 시간측정 시작
		log.info("타이머시작");

		//////// 주관심 실행 코드//////////////////////
		Object result = invocation.proceed(); //주관심사의 함수 호출
		//////////////////////////////////////////////
		sw.stop();
		log.info("타이머 끝");
		log.info("[TimeeLog] Method : " + invocation.getMethod()); // 실행한 Method 명칭
		System.out.println("[TimerLOG] args: " + Arrays.toString(invocation.getArguments()));
		log.info("[TimerLog] process Time: " + sw.getTotalTimeMillis()); // 작업에 걸린 시간
		
		return result;
	}

}
