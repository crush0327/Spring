package ex01.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Curling {

	@Autowired
	private PlayerImpl player;

	public void setPlayer(PlayerImpl player) { // DI
		this.player = player;
	}

}
