import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class LoginAuthenticator  implements Callable{
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		Boolean isLoginSucessfull = (Boolean) message.getPayload();
		System.out.println("LoginAuthenticator.onCall()"+isLoginSucessfull);
		if(!isLoginSucessfull){
			message.setPayload(isLoginSucessfull);
			eventContext.setStopFurtherProcessing(true);
		}
		
		return message;
	}
}
