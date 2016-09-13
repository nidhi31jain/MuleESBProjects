
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.api.config.ConfigurationException;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

public class TestOrchestra {

	
	
	public TestOrchestra(){
		MuleContext muleContext;
		try {
			
			System.setProperty("app.home", "C:\\MuleWorkspace\\.mule\\apps\\loginform\\");
			muleContext = new DefaultMuleContextFactory().createMuleContext();
			ConfigurationBuilder builder = new SpringXmlConfigurationBuilder("C:\\MuleWorkspace\\loginform\\src\\main\\app\\loginform.xml");
			builder.configure(muleContext);
			
			muleContext.start();
		    MuleClient muleClient = muleContext.getClient();
		    //<end id="lis_12_mule-full-start"/>

		    MuleMessage response = muleClient.request(
		        "http://localhost:8081/checkstatus/?username=read-only-admin&source=chn&destination=us", 1000);

		    //sucessfull user and sucessfull response
		    //MuleMessage response = muleClient.request(
			//        "http://localhost:8081/checkstatus/?username=read-only-admin&source=chn&destination=sng", 1000);

		    
		    //unsucessfull user.
		    //MuleMessage response = muleClient.request(
			//        "http://localhost:8081/checkstatus/?username=read-only-admin1&source=chn&destination=sng", 1000);

		    //muleContext.dispose();

		    final String actualPayload = response.getPayloadAsString();
		    System.out.println("TestChoice.TestChoice()"+actualPayload);
			
		} catch (InitialisationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void main(String args[]){
			new TestOrchestra();
		}
	 
}
