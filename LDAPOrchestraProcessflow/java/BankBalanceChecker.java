import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class BankBalanceChecker implements Callable{
	
	static Map<String,Long> userBalanceMap = new HashMap<String,Long>();
	
	static{
		//userBalanceMap.put("read-only-admin_US", 30000L);
		userBalanceMap.put("read-only-admin_US", 25000L);
		userBalanceMap.put("read-only-admin_SNG", 10000L);
		userBalanceMap.put("read-only-admin_MA", 15000L);
	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		FlightInfo flightInfo = (FlightInfo)message.getPayload();
		String username =message.getInvocationProperty("username");
		String destination = flightInfo.getDestination(); 
		long userBankBalance =  userBalanceMap.get(username+"_"+destination);
		
		
		long flightCost= flightInfo.getCost();
		
		if(flightCost>userBankBalance){
			long reqAmount = flightCost-userBankBalance;
			String error = "Bank Balance is low than Required Amount by:"+reqAmount;
			System.out.println("BankBalanceChecker.error:"+error);
			flightInfo.setMessage(error);
			message.setPayload(error);
			
			
			return message;
		}
		
		System.out.println("BankBalanceChecker.onCall()"+flightInfo);
		
		return flightInfo;
	}
	
}
