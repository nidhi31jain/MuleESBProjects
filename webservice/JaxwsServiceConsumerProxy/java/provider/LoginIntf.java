package provider;
import javax.jws.WebService;

@WebService
public interface LoginIntf {
	LoginResponse verify(LoginRequest request);
}