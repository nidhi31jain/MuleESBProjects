package test;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

import com.api.EmployeeAPI;

public class TestAPI {
 
		public final static String[] MULE3_CONFIG_FILES = { "muleapi.xml" };

		public static void main(String[] args) throws Exception {
			/*
			 * Change here to use different configuration file for the Mule context.
			 * Remember to change the Mule libraries accordingly!
			 */
			String[] theConfigFiles = MULE3_CONFIG_FILES;
			DefaultMuleContextFactory theMuleContextFactory = new DefaultMuleContextFactory();
			SpringXmlConfigurationBuilder theSpringConfigBuilder = new SpringXmlConfigurationBuilder(
					theConfigFiles);
			MuleContext theMuleContext = theMuleContextFactory
					.createMuleContext(theSpringConfigBuilder);
			theMuleContext.start();
			
			EmployeeAPI api = theMuleContext.getRegistry().get("empAPI");
			api.searchEmployee("1");
		}
	 

}
