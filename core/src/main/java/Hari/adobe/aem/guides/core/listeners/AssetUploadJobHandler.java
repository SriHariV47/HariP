package Hari.adobe.aem.guides.core.listeners;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

@Component(service = EventHandler.class, immediate = true, property = {
//EventConstants.SERVICE_ + "=DAM Asset Events ",
EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
EventConstants.EVENT_FILTER + "= (path=/content/dam/*)" })
public class AssetUploadJobHandler implements EventHandler, JobConsumer {

    @Override
    public void handleEvent(Event event) {
        // This method is called when a new asset is added to the DAM
        String path = (String) event.getProperty("path");
        System.out.println("Asset uploaded successfully: " + path);
    }

    @Override
    public JobResult process(Job job) {
        // This method is part of the JobConsumer interface
        // You can implement additional logic here if needed
        return JobResult.OK;
    }
}

