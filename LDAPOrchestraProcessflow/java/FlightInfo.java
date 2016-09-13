
public class FlightInfo {

	private String flightName;
	private String source;
	private String destination;
	private long cost;
	private int noOfTransit;
	private String message;
	 
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the flightName
	 */
	public String getFlightName() {
		return flightName;
	}
	/**
	 * @param flightName the flightName to set
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the cost
	 */
	public long getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(long cost) {
		this.cost = cost;
	}
	/**
	 * @return the noOfTransit
	 */
	public int getNoOfTransit() {
		return noOfTransit;
	}
	/**
	 * @param noOfTransit the noOfTransit to set
	 */
	public void setNoOfTransit(int noOfTransit) {
		this.noOfTransit = noOfTransit;
	}
	
	/*public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table border=1>");
		buffer.append("	<tr><td>Airline</td>");
		buffer.append("		<td>Source</td>");
		buffer.append("		<td>Destination</td>");
		buffer.append("		<td>Amount</td>");
		buffer.append("		<td>No.of Transit</td>");
		buffer.append(" </tr>");
				
		
		buffer.append("<tr><td>"+name+"</td>");
		buffer.append("		<td>"+source+"</td>");
		buffer.append("		<td>"+destination+"</td>");
		buffer.append("		</td>"+cost+"</td>");
		buffer.append("		</td>"+noOfTransit+"</td>");
		buffer.append("</tr></table>");
		
		
		return buffer.toString();
	}*/
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Airline:"+flightName+"\n");
		buffer.append("Source:"+source+"\n");
		buffer.append("Destination:"+destination+"\n");
		buffer.append("Cost:"+cost+"\n");
		buffer.append("No.ofTransit:"+noOfTransit+"\n");
		
		
		
		return buffer.toString();
	}
}
