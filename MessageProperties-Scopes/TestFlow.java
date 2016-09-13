import org.mule.api.MuleContext;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

/**
 * Class responsible for testing flow scopes 
 * Outbound- default scope available only in single flow
 * Invocation- available even when traversing the transport 
 * Session - avaialable throught the flow.
 * @author Arunsadhasviam
 *
 */
public class TestFlow {
	MuleContext muleContext;
	TestFlow() {
		try{
			testOutbound();
			testInVocation();
			testSession();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * To test OUtbound flow
	 * @throws Exception
	 */
	private void testOutbound() throws Exception{
		muleContext = new DefaultMuleContextFactory().createMuleContext();
		ConfigurationBuilder builder = new SpringXmlConfigurationBuilder(
				"C:\\MuleWorkspace\\flows\\src\\main\\app\\Outboundflowscopes.xml");
		builder.configure(muleContext);
		muleContext.start();
		MuleClient muleClient = muleContext.getClient();
		MuleMessage response = muleClient.request(
				"http://localhost:8081/outbound", 1000);

		final String actualPayload = response.getPayloadAsString();
		System.out.println("TestFlow.testOutbound():actualPayload:::"+actualPayload);
		muleContext.stop();
	}

	
	/**
	 * To test invocation flow
	 * @throws Exception
	 */
	private void testInVocation()  throws Exception{
		muleContext = new DefaultMuleContextFactory().createMuleContext();
		ConfigurationBuilder builder = new SpringXmlConfigurationBuilder(
				"C:\\MuleWorkspace\\flows\\src\\main\\app\\Invocationflowscopes.xml");

		builder.configure(muleContext);
		muleContext.start();
		MuleClient muleClient = muleContext.getClient();
		MuleMessage response = muleClient.request(
				"http://localhost:8081/invocation", 1000);

		final String actualPayload = response.getPayloadAsString();
		System.out.println("TestFlow.testOutbound():testInVocation:::"+actualPayload);
		muleContext.stop();
	}

	
	/**
	 * To test Session flow
	 * @throws Exception
	 */
	private void testSession()  throws Exception{
		muleContext = new DefaultMuleContextFactory().createMuleContext();
		ConfigurationBuilder builder = new SpringXmlConfigurationBuilder(
				"C:\\MuleWorkspace\\flows\\src\\main\\app\\Sessionflowscopes.xml");

		builder.configure(muleContext);
		muleContext.start();
		MuleClient muleClient = muleContext.getClient();
		MuleMessage response = muleClient.request(
				"http://localhost:8081/session", 1000);

		final String actualPayload = response.getPayloadAsString();
		System.out.println("TestFlow.testOutbound():testSession:::"+actualPayload);
	}

	public static void main(String args[]) {
		new TestFlow();
	}

}
