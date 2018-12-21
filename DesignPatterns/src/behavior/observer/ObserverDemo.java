package behavior.observer;

public class ObserverDemo {

	// In observer pattern, the object that watch on the state of another object are called Observer and the object that is being watched is called Subject.
	public static void main(String args[]) {
		Subject subject = new MessageStream();
		
		PhoneClient phoneClient = new PhoneClient(subject);

		
		phoneClient.addMessage("Here is a new message!");

	}
	
}
