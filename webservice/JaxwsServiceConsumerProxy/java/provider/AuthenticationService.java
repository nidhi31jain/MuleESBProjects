
package provider;

public class AuthenticationService implements LoginIntf{

	@Override
	public LoginResponse verify(LoginRequest request) {
		
		LoginResponse response = new LoginResponse();
		if(request!=null ){
			if(request.getName().equals(request.getPassword())){
				
				response.setAuthroized(true);
			}else{
				response.setAuthroized(false);
			}
		}
		
		return response;
	}
	 

}
