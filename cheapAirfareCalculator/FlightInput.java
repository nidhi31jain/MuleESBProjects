
public class FlightInput {
private String source;
private String destination;
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

public String toString(){
	StringBuffer buffer =new StringBuffer();
	buffer.append("source:"+this.source);
	buffer.append("\n destination:"+this.destination);
	
	return buffer.toString();
}

}
