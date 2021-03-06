package fr.unilim.fr;

import org.junit.Test;

import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;


import static org.junit.Assert.assertEquals;



public class TestDoublures {
	@Test
	public void test_UnPremierStub() {

		User user = mock(User.class); //cr?ation de la doublure
		when(user.getLogin()).thenReturn("alice"); //bouchonnage de la doublure
		
		System.out.println(user.getLogin());
		
		assertEquals(user.getLogin(), "alice");
		//assertEquals(user.getLogin(), "bob");
	}
	
	@Test
	public void test_UnPremierMock() {

		 User user = mock(User.class);
		 when(user.getLogin()).thenReturn("alice");

		 System.out.println(user.getLogin());
		 System.out.println(user.getLogin());

		 verify(user, times(2)).getLogin(); //V?rification de l'affichage appel? 2 fois
		 //verify(user).getLogin(); //verifier que la m?thode a ?t? appel?
		 
	}
	 
	@Test
	public void test_OptionsVerification() {

		LinkedList<String> mockedList = mock(LinkedList.class);

		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		//following two verifications work exactly the same - times(1) is used by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		//exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		//verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		//verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");
	}
}
