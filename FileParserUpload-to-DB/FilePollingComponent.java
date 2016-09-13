import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;


public class FilePollingComponent implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		File f = new File("c:/ESB/input/");
	    List<File> filesToReturn = new ArrayList<File>(1);
	    if(f.isDirectory())
	    {
	        File[] files = f.listFiles();
	       
	        for(File file : files)
	        {
	            if(file.isFile())
	                filesToReturn.add(file);
	           
	        }
	    }
	    else
	    {
	        throw new Exception("Invalid Directory");
	    }
	    MuleMessage message = eventContext.getMessage();
	    message.setPayload(filesToReturn);
	    message.setOutboundProperty("fileList", filesToReturn);
	    
	    return filesToReturn;
	}

}
