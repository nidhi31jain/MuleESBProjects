
public class ActiveMQException extends Exception{

	private static final long serialVersionUID = 1123544523432L;
	String mistake;
	
	public ActiveMQException() {
		super();
		mistake = "test";
	}
	
	public ActiveMQException(String err) {
		super(err);
		mistake = err;
	}
	
	 public String getError()
	  {
	    return mistake;
	  }

}