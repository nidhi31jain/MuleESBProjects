import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class CheapAirFairPredictor implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		FlightInfo flightinfo = null;

		try {
			MuleMessage message = eventContext.getMessage();
			FlightInput flightInput = message.getInvocationProperty("searchInput");
			String fileContent = eventContext.getMessageAsString();
			String files[] = fileContent.split("\r\n");
			long price = 0;

			int length = files.length;
			for (int i = 0; i < length; i++) {
				String file = files[i];
				FlightInfo currentbean = getFlightInfo(file);
				String source = currentbean.getSource();
				String destination = currentbean.getDestination();
				long tmpCost= currentbean.getCost();
				
				// filter and display cheap air plane based on source and
				// destination
				// parameter.
				if (!(source.equalsIgnoreCase(flightInput.getSource())
						&& destination.equalsIgnoreCase(flightInput.getDestination()))) {
					continue;
				}
				
				//first time set
				if(price==0){
					flightinfo = currentbean;
				}
				if (tmpCost < price) {
					flightinfo = currentbean;
				}
				
				price = tmpCost;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flightinfo;
	}

	
	/**
	 * To return flight object
	 * @param content
	 * @return
	 */
	private FlightInfo getFlightInfo(String file) {

		FlightInfo flightinfo = new FlightInfo();
		String[] content = file.split("\\|");

		String flightName = getString(content[0]);
		String source = getString(content[1]);
		String destination = getString(content[2]);
		String strfTransit = content[4];
		int noOfTransit = (strfTransit == null) ? 0 : Integer.parseInt(content[4]);
		long tmpPrice = getLong(content[3]);

		flightinfo.setFlightName(flightName);
		flightinfo.setSource(source);
		flightinfo.setDestination(destination);
		flightinfo.setCost(tmpPrice);
		flightinfo.setNoOfTransit(noOfTransit);

		return flightinfo;
	}
	
	/**
	 * To return long value
	 * 
	 * @param val
	 * @return
	 */
	public Long getLong(String val) {
		if (val == null) {
			return 0l;
		}

		return Long.parseLong(val);
	}

	/**
	 * To return String value
	 * 
	 * @param val
	 * @return
	 */
	public String getString(String val) {
		if (val == null) {
			return "";
		}

		return val;
	}

}
