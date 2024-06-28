package Hari.adobe.aem.guides.core.listeners;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import com.day.cq.replication.ReplicationAction;

@Component(
    service = EventHandler.class,
    property = {
        EventConstants.EVENT_TOPIC + "=" + ReplicationAction.EVENT_TOPIC
    }
)
public class ReplicationEventHandler implements EventHandler {
    private static final String TAG = ReplicationEventHandler.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(ReplicationEventHandler.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void handleEvent(Event event) {
        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, "hari");

        try (ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(param)) {
            LOGGER.info("Page is published successfully");
            String[] paths = (String[]) event.getProperty("paths");
            if (paths != null && paths.length > 0) {
                String payloadPath = paths[0];
                if (StringUtils.isNotEmpty(payloadPath)) {
                    WorkflowSession workflowSession = resolver.adaptTo(WorkflowSession.class);
                    if (workflowSession != null) {
                        final String model = "/var/workflow/models/pdfworkflow";
                        WorkflowModel workflowModel = workflowSession.getModel(model);
                        if (workflowModel != null) {
                            WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", payloadPath);
                            workflowSession.startWorkflow(workflowModel, workflowData);
                            LOGGER.info("Workflow: {} started for payload: {}", model, payloadPath);
                        } else {
                            LOGGER.error("{}: Workflow model not found at path: {}", TAG, model);
                        }
                    } else {
                        LOGGER.error("{}: Could not adapt resource resolver to WorkflowSession", TAG);
                    }
                } else {
                    LOGGER.error("{}: Payload path is empty or null", TAG);
                }
            } else {
                LOGGER.error("{}: Paths property is empty or null in the event", TAG);
            }
        } catch (LoginException e) {
            LOGGER.error("{}: Exception occurred while obtaining a resource resolver: {}", TAG, e.getMessage(), e);
        } catch (WorkflowException e) {
            LOGGER.error("{}: Exception occurred while starting the workflow: {}", TAG, e.getMessage(), e);
        }
    }
}