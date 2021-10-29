package gameofdices;

import org.junit.Test;

import fr.unilim.fr.User;

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.Assert.*;

public class DicesTest {
	
	@Test
	public void rollReturnsAValue() {
		Dice theDice = new Dice(new Random());
		
		for (int i = 0; i < 100; i++) {
			int result = theDice.roll();
			
			assertTrue(result >= 1);
			assertTrue(result <= 6);
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void identifyBadValuesGreaterThanNumberOfFaces() {
		Random tooMuch = mock(Random.class);
		when(tooMuch.nextInt(anyInt())).thenReturn(7);
		Dice theDice = new Dice(tooMuch);
		theDice.roll();
	}
	
	@Test(expected = RuntimeException.class)
	public void identifyBadValuesLesserThanOne() {
		Random notEnough = mock(Random.class);
		when(notEnough.nextInt(anyInt())).thenReturn(-1);
		Dice theDice = new Dice(notEnough);
		theDice.roll();
	}
}
