package firstdoublure;

public class UserServiceImpl implements UserService {

	private final HashProvider hashProvider;
	
	public UserServiceImpl(HashProvider hashProvider) {
    	this.hashProvider = hashProvider;
	}
	
	public User createUser(String firstname, String password) {
		String hashedPassword = hashProvider.hash(password);
		return new User(firstname, hashedPassword);
	}

}
