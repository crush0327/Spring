package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BasketBall {

	@Autowired  //자동 주입된다.
	@Qualifier("player2")
	private PlayerImpl  player;

	public void setPlayer(PlayerImpl player) {  // DI
		this.player = player;
	}
	
}
/*
	@Qualifier
	목적 : @Autowired의 목적에서 동일 타입의 빈객체가 존재시 특정빈을 삽입할 수 있게 설정한다. 
	설정위치 : @Autowired 어노테이션과 함께 사용된다.
	추가설정 : 동일타입의 빈객체 설정에서 <qualifier value="[alias명]" />를 추가하여 준다.
	옵션 : name - alias명
*/