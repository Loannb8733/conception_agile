package firstdoublure;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;


public class UserServiceImplTest {
	
	
	@Test
	public void should_create_user_with_hashed_password() {
		HashProvider hashProvider = mock(HashProvider.class);
		when(hashProvider.hash("secret")).thenReturn("bonjour");
    	
		UserService userService = new UserServiceImpl(hashProvider);
     	
    	User user = userService.createUser("Bob", "secret");

     	assertEquals(user.firstName(), "Bob"); 
     	assertEquals(user.hashedPassword(), hashProvider.hash("secret"));
     	//assertEquals(user.hashedPassword(),"hash"); 
	}
}

