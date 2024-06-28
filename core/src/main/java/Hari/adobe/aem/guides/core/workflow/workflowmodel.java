package Hari.adobe.aem.guides.core.workflow;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service=WorkflowProcess.class,immediate =true,
property = {"process.label=Practice Custom Workflow Process" }
		)
public class workflowmodel  implements WorkflowProcess{

	 protected final Logger log = LoggerFactory.getLogger(workflowmodel.class);
	
	    public void execute(WorkItem workItem, WorkflowSession wfSession,MetaDataMap metaDataMap) throws WorkflowException {
	            
	    	log.info("hari workflow working properly ");
	    }
	

}