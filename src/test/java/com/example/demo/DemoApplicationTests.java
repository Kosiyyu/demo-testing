package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PlayerService playerService;

	@Test
	@DirtiesContext
	public void testCreatePlayerSuccess() {
		Player player2 = playerService.createPlayer("Test Player", 1);
		Player player1 = new Player("Test Player", 1);

		Assertions.assertEquals(player1.getName(), player2.getName());
		Assertions.assertEquals(player1.getPlayerValue(), player2.getPlayerValue());
	}

	@Test
	@DirtiesContext
	public void testFindPlayerSuccess() {
		playerService.createPlayer("Test Player", 1);
		Player player2 = playerService.findPlayer(1);

		Assertions.assertEquals("Test Player", player2.getName());
		Assertions.assertEquals(1, player2.getPlayerValue());
	}

	@Test
	@DirtiesContext
	public void testDeletePlayerSuccess(){
		playerService.createPlayer("Test Player", 1);
		Player player2 = playerService.findPlayer(1);
		playerService.deletePlayer(player2.getId());
		try{
			playerService.findPlayer(1);
		}
		catch (NoSuchElementException e){
			Assertions.assertTrue(e instanceof NoSuchElementException);
		}

		Assertions.assertEquals("Test Player", player2.getName());
		Assertions.assertEquals(1, player2.getPlayerValue());
	}



}
