package provider;

import java.io.Serializable;


public class LoginResponse implements Serializable{
	private boolean isAuthroized;

	/**
	 * @return the isAuthroized
	 */
	public boolean isAuthroized() {
		return isAuthroized;
	}

	/**
	 * @param isAuthroized the isAuthroized to set
	 */
	public void setAuthroized(boolean isAuthroized) {
		this.isAuthroized = isAuthroized;
	}
	
}
