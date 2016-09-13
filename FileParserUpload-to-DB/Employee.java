import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Employee {
private int _id;
private String name;
private String address;

/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}

public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append(" Id:" + _id);
	buffer.append("\t Name:" + name);
	buffer.append("\t Address:" + address +"\n");

	return buffer.toString();

}
/**
 * @return the _id
 */
public int get_id() {
	return _id;
}
/**
 * @param _id the _id to set
 */
public void set_id(int _id) {
	this._id = _id;
}

}
